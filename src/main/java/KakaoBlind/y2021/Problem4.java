package KakaoBlind.y2021;

import java.util.Arrays;

public class Problem4 {
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int fares[][] = {
                {4, 1, 10},
                {3, 5, 24},
                {5, 6, 2},
                {3, 1, 41},
                {5, 1, 24},
                {4, 6, 50},
                {2, 4, 66},
                {2, 3, 22},
                {1, 6, 25}
        };
        new Solution4().solution(n,s,a,b, fares);
    }
}

class Solution4 {
    int dismap[][];


    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        dismap = new int[n+1][n+1];
        for (int i = 1; i <= n ; i++) {
            Arrays.fill(dismap[i], -1);
            dismap[i][i] = 0;
        }
        setMap(fares);
//        for (int i = 1; i <= n ; i++) {
//            System.out.println(Arrays.toString(dismap[i]));
//        }
        return get_ans(n,s,a,b);
    }

    void setMap(int[][] fares){
        for (int i = 0; i < fares.length; i++) {
            int s = fares[i][0];
            int e = fares[i][1];
            int dis = fares[i][2];
            dismap[s][e] = dis;
            dismap[e][s] = dis;
        }
        int n = dismap.length-1;
        for (int k = 1; k <= n ; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(dismap[i][k] == -1 || dismap[j][k] == -1) continue;
                    if(dismap[i][j] == -1) dismap[i][j] = dismap[i][k] + dismap[j][k];
                    else dismap[i][j] = Math.min(dismap[i][k] + dismap[j][k], dismap[i][j]);
                }

            }
        }


    }
    int get_ans(int n, int s, int a, int b){
        int ans = Integer.MAX_VALUE;
        if(dismap[s][a] != -1 && dismap[s][b] != -1) ans = dismap[s][a]+dismap[s][b];
        for (int i = 1; i <= n ; i++) {
            if(i == s || dismap[s][i] == -1 || dismap[i][a] == -1 || dismap[i][b] == -1) continue;
            ans = Math.min(ans, dismap[s][i] + dismap[i][a] + dismap[i][b]);


        }


        return ans;
    }


}

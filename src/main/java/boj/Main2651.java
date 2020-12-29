package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dis = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        long dp[][] = new long[N+2][3];
        int dismap[] = new int[N+2];
        int map[] = new int[N+2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N+1 ; i++) {
            dismap[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N ; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            dp[i][0] = Long.MAX_VALUE;
        }
        dp[N+1][0] = Long.MAX_VALUE;

        for (int i = 0; i <= N; i++) {
            int tmpdis = 0;

            for (int j = 1; i+j <= N+1; j++) {
                tmpdis += dismap[i+j];
                if(tmpdis > dis) break;
                if(dp[i+j][0] > dp[i][0]+map[i+j]){
                    dp[i+j][0] = dp[i][0]+map[i+j];
                    dp[i+j][1] = i;
                    dp[i+j][2] = (dp[i][2]+1);
                }
            }
        }
        System.out.println(dp[N+1][0]);
        System.out.println(dp[N+1][2]-1);
        Stack<Integer> stack = new Stack<Integer>();
        int tmp = (int)dp[N+1][1];
        while(tmp != 0){
            stack.add(tmp);
            tmp = (int)dp[tmp][1];
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();




    }
}

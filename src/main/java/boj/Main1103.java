package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1103 {
    static final int dx[] = {0,1,0,-1};
    static final int dy[] = {-1,0,1,0};
    static int N, M;
    static int map[][], dp[][];
    static boolean is_visit[][];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];
        is_visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
//                char tmp = str.charAt(j);
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int tmp = Math.max(ans,game(0,0));
        if(ans == -1) {
            System.out.println(-1);
            return;
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
////                is_visit[i][j] = true;
//                int tmp = Math.max(game(j, i), ans);
//                if(ans == -1) break;
//                ans = Math.max(tmp, ans);
//
////                is_visit[i][j] = false;
////                System.out.print(map[i][j]+" ");
//            }
////            System.out.println();
//        }
//        System.out.println(dp[0][0]);
        System.out.println(Math.max(tmp, ans));

    }

    static int game(int x, int y){
//        System.out.println(x+" " + y);
        if(map[y][x] == 'H'-'0') return 0;
        if(is_visit[y][x]) ans = -1;
        if(ans == -1) return -1;
        if(dp[y][x] == -1) return 1;
        if(dp[y][x] != 0) return dp[y][x];
        is_visit[y][x] = true;
        int ret = -1;

        for (int i = 0; i < 4; i++) {

            if(!is_map(x+dx[i]*map[y][x], y+dy[i]*map[y][x])) continue;
//            is_visit[y+dy[i]][x+dx[i]] = true;
            int tmp = game(x+dx[i]*map[y][x], y+dy[i]*map[y][x]);
//            is_visit[y+dy[i]][x+dx[i]] = false;
//            if(tmp == -1) continue;
            ret = Math.max(ret, tmp+1);
        }

        is_visit[y][x] = false;
        if(ret == -1) {
            dp[y][x] = -1;
            return 1;
        }
        return dp[y][x] = ret;
    }
    static boolean is_map(int x, int y){
        if(x < 0 || y < 0 || x >= M || y >= N) return false;
        return true;
    }
}

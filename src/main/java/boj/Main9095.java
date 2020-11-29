package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9095 {
    static long dp[] = new long[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            sb.append(solution(tmp)).append("\n");
        }
        System.out.println(sb);
    }

    static long solution(int N){
        long ans = 0;
        if(dp[N] != 0) return dp[N];


        return dp[N] = (solution(N-1) + solution(N-2) + solution(N-3));
    }
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int map[] = new int[N];
        int dp[] = new int[N];
        map[0] = Integer.parseInt(st.nextToken());
        dp[0] = map[0];
        int size = 1;
        for (int i = 1; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            boolean is_end = false;
            for (int j = 0; j < size; j++) {
                if(map[i] <= dp[j]){
                    dp[j] = map[i];
                    is_end = true;
                    break;
                }
            }
            if(!is_end) {
                dp[size++] = map[i];
            }

        }
        System.out.println(N - size);

    }
}

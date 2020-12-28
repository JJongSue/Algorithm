package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14569 {
    static long map[];
    static boolean tmp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new long[N];


        StringTokenizer st;

        int tmp = 1;
        long one = 1;
        long input = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cnt = Integer.parseInt(st.nextToken());
            input = 0;
            for (int j = 0; j < cnt; j++) {
                tmp =  Integer.parseInt(st.nextToken());
                one = 1;
                input |= (one<<tmp);
            }
            map[i] = input;

        }
        int anscnt = 0;
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            cnt = Integer.parseInt(st.nextToken());
            input = 0;
            for (int j = 0; j < cnt; j++) {
                tmp =  Integer.parseInt(st.nextToken());
                one = 1;
                input |= (one<<tmp);
            }
            anscnt = 0;
            for (int j = 0; j < N; j++) {
                if((map[j] & input) == map[j]) anscnt++;
            }
            sb.append(anscnt).append("\n");
        }
        System.out.println(sb);
    }
}

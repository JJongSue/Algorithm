package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cmd = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            cmd[i] = Integer.parseInt(st.nextToken());
//            dq.add((N-i));
        }
        for (int i = N-1; i >= 0 ; i--) {
            if(cmd[i] == 1) {
                dq.addFirst((N-i));
            }else if(cmd[i] == 2){
                int tmp =dq.pollFirst();
                dq.addFirst((N-i));
                dq.addFirst(tmp);
            }else{
                dq.addLast((N-i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()) sb.append(dq.pollFirst()).append(' ');
        System.out.println(sb);

    }
}

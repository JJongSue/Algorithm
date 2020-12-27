package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18119 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); 
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            int input = 0;
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                input |= (1 << (c-'a'));
            }
            arr[i] = input;
        }
        
        StringBuilder sb = new StringBuilder();
        int cmp = 0;
        for (int i = 0; i < 26; i++) {
            cmp |= (1<<i);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
//            String cmd = st.nextToken();
            if(st.nextToken().charAt(0) == '1'){
                cmp ^= (1<<(st.nextToken().charAt(0)-'a'));
            }else{
                cmp |= (1<<(st.nextToken().charAt(0)-'a'));
            }
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                cnt += ( (arr[j] == (cmp & arr[j])) ? 1 : 0 );
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}

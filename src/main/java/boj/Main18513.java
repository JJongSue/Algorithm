package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18513 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        HashSet<Integer> hs = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            q.add(tmp);
            hs.add(tmp);
        }

        int now = 1;
        long ans = 0;
        int home = 0;
        while(home != K){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cnt = 0;
                int tmp = q.poll();
                if(home == K) break;
//                System.out.print(tmp.num + " ");
                if(!hs.contains(tmp + now)){
                    hs.add(tmp + now);
                    cnt++;
                    ans+= now;
                    home++;
                }
                if(home == K) break;
                if(!hs.contains(tmp - now)){
                    hs.add(tmp - now);
                    cnt++;
                    ans+= now;
                    home++;
                }
                if(cnt != 0) q.add(tmp);
            }



            now++;
        }
        System.out.println(ans);

    }
}

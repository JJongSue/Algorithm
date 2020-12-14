package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue<Integer> q[] = new LinkedList[1001];
        int maxd = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(q[d] == null) q[d] = new LinkedList<>();
            q[d].add(w);
            maxd = Math.max(maxd, d);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int ans = 0;
        for (int i = maxd; i >= 1; i--) {
            if(q[i] != null) pq.addAll(q[i]);
            if(!pq.isEmpty()) ans += pq.poll();
            //while(!q[i].isEmpty()) pq.add(q[i].poll());
        }
        System.out.println(ans);


    }
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] al = new ArrayList[N+1];
        int[] cntMap = new int[N+1];
        int[] timeMap = new int[N+1];
        PriorityQueue<Work> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            timeMap[i] = time;
            cntMap[i] = cnt;

            if(cnt == 0){
                pq.add(new Work(i, time));
                continue;
            }
            for (int j = 0; j < cnt; j++) {
                int next = Integer.parseInt(st.nextToken());
                al[next].add(i);
            }
        }
        int answer = 0;
        while(!pq.isEmpty()){
            Work working = pq.poll();
            answer = working.time;
            int size = al[working.now].size();
            for (int i = 0; i < size; i++) {
                int go = al[working.now].get(i);
                cntMap[go]--;
                if(cntMap[go] == 0){
                    pq.add(new Work(go, answer+timeMap[go]));
                }

            }
        }
        System.out.println(answer);


    }
    static class Work implements Comparable<Work> {
        int now;
        int time;

        public Work(int now, int time) {
            this.now = now;
            this.time = time;
        }

        @Override
        public int compareTo(Work o) {
            return this.time - o.time;
        }
    }
}

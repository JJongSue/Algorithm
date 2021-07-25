package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main10217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] timeMap = new int[N+1][M+1];
            List<Root>[] al = new ArrayList[N + 1];


            for (int i = 0; i <= N; i++) {
                al[i] = new ArrayList<>();
                Arrays.fill(timeMap[i], Integer.MAX_VALUE);
            }
//            Arrays.fill(al, new ArrayList<Root>());

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                al[s].add(new Root(e, value, time));
            }
            timeMap[1][0] = 0;


            PriorityQueue<Root> pq = new PriorityQueue<>();
            for (int i = 0; i < al[1].size(); i++) {
                Root tmp = al[1].get(i);
                if (tmp.value <= M) {
                    pq.add(tmp);
                }
            }


            int answer = -1;
            while (!pq.isEmpty()) {
                int go = pq.peek().go;
                int value = pq.peek().value;
                int time = pq.poll().time;

                if(timeMap[go][value] < time){
                    continue;
                }
                if(go == N){
                    answer = time;
                    break;
                }
//                timeMap[go][value] = time;

                for (int i = 0; i < al[go].size(); i++) {
                    int next = al[go].get(i).go;
                    int nextValue = al[go].get(i).value + value;
                    int nextTime = al[go].get(i).time + time;
                    if(nextValue <= M && nextTime < timeMap[next][nextValue]){
                        pq.add(new Root(next, nextValue, nextTime));
                        timeMap[next][nextValue] = nextTime;
                    }
                }

            }


            if (answer == -1) {
                sb.append("Poor KCM\n");
            } else {
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb);
    }

    static class Root implements Comparable<Root> {
        int go;
        int value;
        int time;

        public Root(int go, int value, int time) {
            this.go = go;
            this.value = value;
            this.time = time;
        }

        @Override
        public int compareTo(Root o) {
            if (this.time == o.time) {
                return this.value - o.value;
            }
            return this.time - o.time;
        }
    }
}

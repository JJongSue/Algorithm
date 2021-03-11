package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main10282 {
    static PriorityQueue<dot> pq;
    static ArrayList<dot>[] al;
    static int[] dismap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int tc = 0;tc<T;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq = new PriorityQueue<>();
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            dismap = new int[N+1];
            al = new ArrayList[N+1];
            for (int i = 1; i <= N; i++) {
                al[i] = new ArrayList<>();
                dismap[i] = Integer.MAX_VALUE;
            }


            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int e = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int dis = Integer.parseInt(st.nextToken());
                al[s].add(new dot(e, dis));
            }

            dismap[C] = 0;
            pq.add(new dot(C,0));
//            pq.addAll(al[C]);
            int cnt = 0;
            int time = 0;
            while(!pq.isEmpty()){
                dot now = pq.poll();
                if(now.dis > dismap[now.go]) continue;
//                System.out.println(tc+" "+now.go+" "+now.dis);
                cnt++;
                time = now.dis;
                for (dot tmp : al[now.go]) {
                    if(dismap[tmp.go] > dismap[now.go] + tmp.dis){
                        pq.add(new dot(tmp.go, dismap[now.go] + tmp.dis));
                        dismap[tmp.go] = dismap[now.go] + tmp.dis;
                    }
                }
            }
            sb.append(cnt).append(" ").append(time).append("\n");

        }
        System.out.println(sb);
    }
    static class dot implements Comparable<dot>{
        int go;
        int dis;

        public dot(int go, int dis) {
            this.go = go;
            this.dis = dis;
        }

        @Override
        public int compareTo(dot o) {
            return this.dis - o.dis;
        }
    }
}

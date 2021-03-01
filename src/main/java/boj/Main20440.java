package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main20440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        time map[] = new time[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = new time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(map, new Comparator<time>() {
            @Override
            public int compare(time o1, time o2) {
                if(o1.s == o2.e){
                    return o1.e - o2.e;
                }
                return o1.s - o2.s;
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(map[0].e);
        int anscnt=1;
        int anss=map[0].s;
        int anse=map[0].e;

        for (int i = 1; i < N; i++) {
            while(!pq.isEmpty() && pq.peek() < map[i].s){
                pq.poll();
            }
            if(!pq.isEmpty() && pq.peek() == map[i].s){
                if(pq.peek() == anse) anse = map[i].e;
                pq.poll();
            }
            pq.add(map[i].e);
            if(pq.size() > anscnt){
                anscnt = pq.size();
                anss = map[i].s;
                anse = pq.peek();
            }
        }
        System.out.println(anscnt);
        System.out.println(anss + " " + anse);


    }
    static class time{
        int s;
        int e;

        public time(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}

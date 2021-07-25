package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2211 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] disMap = new int[N + 1][N + 1];
        int[] minMap = new int[N+1];
        Arrays.fill(minMap, Integer.MAX_VALUE);
        ArrayList<Line>[] al = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {            
            al[i] = new ArrayList<>();            
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            al[x].add(new Line(y, time));
            al[y].add(new Line(x, time));
        }
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        for (Line tmp :
                al[1]) {
            pq.add(new Computer(1, tmp.go, tmp.time));
        }
        minMap[1] = 0;
        


        int lineCount = 0;
        while (!pq.isEmpty()) {
            int x = pq.peek().x;
            int y = pq.peek().y;
            int time = pq.poll().time;
            if (minMap[y] <= time) {
                continue;
            }
            minMap[y] = time;
            for (int i = 0; i < al[y].size(); i++) {
                int go = al[y].get(i).go;
                int goTime = al[y].get(i).time;
                if(minMap[go] > goTime + minMap[y]){
                    pq.add(new Computer(y, go, minMap[y]+goTime));
                }
            }
            sb.append(x).append(' ').append(y).append('\n');
            lineCount++;

        }


        System.out.println(lineCount);
        System.out.print(sb);
    }

    static class Line {
        int go;
        int time;

        public Line(int go, int time) {
            this.go = go;
            this.time = time;
        }
    }

    static class Computer implements Comparable<Computer> {
        int x;
        int y;
        int time;

        public Computer(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Computer o) {
            return this.time - o.time;
        }
    }
}

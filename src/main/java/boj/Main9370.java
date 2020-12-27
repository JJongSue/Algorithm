package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main9370 {
    static PriorityQueue<City> pq;
    static ArrayList<City> al[];
    static int dismap[], dismap2[], tmap[];
    static boolean ansmap[];
    static class City implements Comparable<City> {
        int w;
        int dis;
        public City(int w, int dis) {
            this.w = w;
            this.dis = dis;
        }


        @Override
        public int compareTo(City o) {
            return this.dis - o.dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pq = new PriorityQueue<>();int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test = 0; test < T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            al = new ArrayList[n+1];

            dismap = new int[n+1];
            dismap2 = new int[n+1];
            ansmap = new boolean[n+1];
            tmap = new int[t];

            for (int i = 1; i <= n; i++) {
                al[i] = new ArrayList<>();
                dismap[i] = -1;
                dismap2[i] = -1;
            }

            int gh = 0;


            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                al[a].add(new City(b,c));
                al[b].add(new City(a,c));
                if(a == g && b == h || b == g && a == h) {
                    gh = c;
                }
            }

            for (int i = 0; i < t; i++) {
                tmap[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(tmap);
//            System.out.println(Arrays.toString(tmap));

            pq.add(new City(s,0));

            while(!pq.isEmpty()){
                City city = pq.poll();
                if(dismap[city.w] != -1) continue;
                dismap[city.w] = city.dis;
                for (int i = 0; i < al[city.w].size(); i++) {
                    int go = al[city.w].get(i).w;
                    int dis = al[city.w].get(i).dis;
                    if(dismap[go] == -1) {
                        pq.add(new City(go, dismap[city.w] + dis));
                    }
                }
            }
//            for (int i = 1; i <= n; i++) {
//                System.out.print(dismap[i]+" ");
//            }

            int des = 0;

            if(dismap[g] + gh == dismap[h]){
                pq.add(new City(h, 0));
                while(!pq.isEmpty()){
                    City city = pq.poll();
                    if(dismap2[city.w] != -1) continue;
                    dismap2[city.w] = city.dis;
                    for (int i = 0; i < al[city.w].size(); i++) {
                        int go = al[city.w].get(i).w;
                        int dis = al[city.w].get(i).dis;
                        if(dismap2[go] == -1) {
                            pq.add(new City(go, dismap2[city.w] + dis));
                        }
                    }
                }
//                System.out.println();
//                for (int i = 1; i <= n; i++) {
//                    System.out.print(dismap2[i]+" ");
//                }
                for (int i = 0; i < t; i++) {
                    if(dismap[tmap[i]] == dismap2[tmap[i]] + dismap2[s]){
                        sb.append(tmap[i]).append(" ");
                    }
                }


            }else if(dismap[h] + gh == dismap[g]){
                pq.add(new City(g, 0));
                while(!pq.isEmpty()){
                    City city = pq.poll();
                    if(dismap2[city.w] != -1) continue;
                    dismap2[city.w] = city.dis;
                    for (int i = 0; i < al[city.w].size(); i++) {
                        int go = al[city.w].get(i).w;
                        int dis = al[city.w].get(i).dis;
                        if(dismap2[go] == -1) {
                            pq.add(new City(go, dismap2[city.w] + dis));
                        }
                    }
                }
//                System.out.println();
//                for (int i = 1; i <= n; i++) {
//                    System.out.print(dismap2[i]+" ");
//                }
                for (int i = 0; i < t; i++) {
                    if(dismap[tmap[i]] == dismap2[tmap[i]] + dismap2[s]){
                        sb.append(tmap[i]).append(" ");
                    }
                }

            }
            sb.append("\n");



        }
        System.out.println(sb);
    }
}

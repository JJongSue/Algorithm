package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main15647 {
    static int cntmap[], N;
    static long ansmap[], dismap[];
    static ArrayList<Farm> al[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
//        N = 3 ;
        ansmap = new long[N+1];
        dismap = new long[N+1];
        cntmap = new int[N+1];
        al = new ArrayList[N+1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            al[i] = new ArrayList<>();
            cntmap[i]++;
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
//            int s = i+1;
//            int e = i+2;
//            int d = 5;
            al[s].add(new Farm(e,d));
            al[e].add(new Farm(s,d));
        }
        al[1].add(new Farm(0, 0));
        set_dis(0,1,0);
        ansmap[1] = dismap[1];
        set_ans(0,1,0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
//            System.out.println(i+" "+dismap[i]+" "+cntmap[i]+" "+ansmap[i]);
//            System.out.println(ansmap[i]);
            sb.append(ansmap[i]).append("\n");
        }
        System.out.println(sb);

    }
    // up은 상위, now는 현재위치
    static long set_dis(int up, int now, int updis){
        if(al[now].size() == 1){
            cntmap[up]++;
            return al[now].get(0).d;
        }

        for (int i = 0; i < al[now].size(); i++) {
            if(al[now].get(i).go == up) continue;
            dismap[now] += set_dis(now, al[now].get(i).go, al[now].get(i).d);
        }
        cntmap[up]+= cntmap[now];


        return (dismap[now]+(cntmap[now]*updis));
    }

    static void set_ans(int up, int now, int updis){
        if(now != 1){
            ansmap[now] = ansmap[up] - (updis * cntmap[now]) + ((N - cntmap[now])*updis);
        }
        for (int i = 0; i < al[now].size(); i++) {
            if(al[now].get(i).go == up) continue;
            set_ans(now, al[now].get(i).go, al[now].get(i).d);
        }

    }

    static class Farm{
        int go;
        int d;

        public Farm(int go, int d) {
            this.go = go;
            this.d = d;
        }
    }
}

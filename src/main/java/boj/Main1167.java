package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main1167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
//        int N = 100_000;
        StringTokenizer st;
        ArrayList<dot>[] al = new ArrayList[N+1];
        int ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            al[tmp] = new ArrayList<dot>();
            int tmp2 = 0;
            while(( tmp2 = Integer.parseInt(st.nextToken()) ) != -1){
                al[tmp].add(new dot(tmp2, Integer.parseInt(st.nextToken())));
            }
        }
//        al[1] = new ArrayList<>();
//        al[1].add(new dot(2,1));
//        for (int i = 2; i < N; i++) {
//            al[i] = new ArrayList<dot>();
//            al[i].add(new dot(i+1,1));
//            al[i].add(new dot(i-1,1));
//
//        }
//        al[N] = new ArrayList<>();
//        al[N].add(new dot(N-1,1));

        boolean[] is_visit = new boolean[N+1];

        //0 부모 1부모와의거리 2 자식cnt 3 : first 4: second
        int[][] map = new int[N+1][5];

        Stack<Integer> stack = new Stack<Integer>();
        stack.add(1);
//        map[1][2]++;

        while(!stack.isEmpty()){
            int now = stack.peek();
            //System.out.println(now);
            is_visit[now] = true;
            if(map[now][2] == al[now].size()) {
                stack.pop();
//                System.out.println(now+" "+map[now][3]);
                ans = Math.max(ans, map[now][3] + map[now][4]);
                //int sum = map[now][3] + map[now][4];
                int nowmax = map[now][3] + map[now][1];
                int p = map[now][0];
                //int pdis = map[now][1];
                if(nowmax  >= map[p][3]){
                    map[p][4] = map[p][3];
                    map[p][3] = nowmax;
                }else if( nowmax > map[p][4] ){
                    map[p][4] = nowmax;
                }
                map[p][2]++;
            }

            for (int i = 0; i < al[now].size(); i++) {
                int go = al[now].get(i).go;
                if(is_visit[go]) continue;
                stack.add(go);
                map[go][2]++;
                map[go][0] = now;
                map[go][1] = al[now].get(i).dis;
            }

        }
        ans = Math.max(ans, map[1][3]+map[1][4]);
        System.out.println(ans);

    }

    static class dot{
        int go;
        int dis;

        public dot(int go, int dis) {
            this.go = go;
            this.dis = dis;
        }
    }


}

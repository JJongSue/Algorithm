package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1043 {
    static int parents[];

    static int get_parents(int now){
        if(parents[now] <= 0) return now;
        return parents[now] = get_parents(parents[now]);
    }

    static void union(int a, int b){
        int pa = get_parents(a);
        int pb = get_parents(b);
        if(pa == pb) return;
        parents[pa] += parents[pb];
        parents[pb] = pa;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < cnt; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            parents[tmp] = -1;
        }

        int party[][] = new int[M][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            cnt = Integer.parseInt(st.nextToken());
            party[i][0] = cnt;
//            if(cnt == 0) continue;
            party[i][1] = Integer.parseInt(st.nextToken());
            for (int j = 2; j <= cnt; j++) {
                party[i][j] = Integer.parseInt(st.nextToken());
                union(party[i][1], party[i][j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < M; i++) {
            if(parents[get_parents(party[i][1])] == 0) ans++;
        }


        System.out.println(ans);



    }
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2357 {
    static class IndexTree{
        private int size;
        private int start;
        private int maxarr[];
        private int minarr[];

        public IndexTree(int start) {
            this.start = start;
            this.size = (start << 1);
            this.maxarr = new int[size+1];
            this.minarr = new int[size+1];

            for (int i = 0; i <= size; i++) {
                minarr[i] = Integer.MAX_VALUE;
                maxarr[i] = Integer.MIN_VALUE;
            }
        }

        void add (int w, int data){
            maxarr[w+start] = data;
            minarr[w+start] = data;
        }

        void setArr(){
            int now = start;
            while(now != 1){
                for(int i=(now >> 1); i<now; i++) {
                    maxarr[i] = Math.max(maxarr[(i << 1)], maxarr[(i << 1) + 1]);
                    minarr[i] = Math.min(minarr[(i << 1)], minarr[(i << 1) + 1]);
                }
                now = (now >> 1);
            }
        }

        void changeNum(int w, int data){
            w += (start - 1);
            maxarr[w] = data;
            minarr[w] = data;
            w = (w >> 1);
            while(w != 1){
                maxarr[w] = Math.max(maxarr[(w << 1)], maxarr[(w << 1)+1]);
                minarr[w] = Math.min(minarr[(w << 1)], minarr[(w << 1)+1]);
                w = (w >> 1);
            }
        }

        int[]  getNum(int a, int b){
//            System.out.println(a + " " + b);
            a += (start - 1);
            b += (start - 1);
            int ans[] = new int[2];
            ans[0] = Integer.MAX_VALUE;
            ans[1] = Integer.MIN_VALUE;

            while(a <= b){
                if(a == b){
                    ans[0] = Math.min(ans[0], minarr[a]);
                    ans[1] = Math.max(ans[1], maxarr[a]);
                    return ans;
                }

                if( a%2 == 0){
                    a = (a >> 1);
                }else{
                    ans[0] = Math.min(ans[0], minarr[a]);
                    ans[1] = Math.max(ans[1], maxarr[a]);
                    a = (a >> 1) + 1;
                }

                if( b%2 == 0){
                    ans[0] = Math.min(ans[0], minarr[b]);
                    ans[1] = Math.max(ans[1], maxarr[b]);
                    b = (b >> 1) - 1;
                }else{
                    b = (b >> 1);
                }



            }

            return ans;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int start = 1;
        for(start = 1; start <= N; start = (start << 1));

        IndexTree it = new IndexTree(start);

        for (int i = 0; i < N; i++) {
            it.add(i, Integer.parseInt(br.readLine()));
        }

        it.setArr();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int ans[] = it.getNum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            sb.append(ans[0]).append(" ").append(ans[1]).append("\n");
        }
        System.out.println(sb);
    }

}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Main2517 {
    static class SegmentTree{
        int size;
        int start;
        int tree[];

        public SegmentTree(int start) {
            this.start = start;
            this.size = (start << 1);
            tree = new int[size+1];
        }

        void add(int num){
            int now = start + num;
            //tree[now]++;
            while(now != 0){
                tree[now]++;
                now = (now>>1);
            }
        }

        int get_num(int num){
            int l = start;
            int r = start + num;
            int ret = 0;
            while(l<=r){
                if(l == r){
                    return ret + tree[l];
                }
                if(l%2 == 0){
                    l = (l>>1);
                }else{
                    ret += tree[l];
                    l = ((l>>1)+1);
                }

                if(r % 2 == 0) {
                    ret += tree[r];
                    r = ((r>>1)-1);
                }else{
                    r = (r>>1);
                }
            }
            return ret;
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = 1;
        for(start = 1 ; start <= N ; start = (start << 1));

        int arr[] = new int[N];
        Integer map[] = new Integer[N];

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;
            map[i] = input;
        }
        Arrays.sort(map, Collections.reverseOrder());
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            hm.put(map[i], i);
        }
        SegmentTree st = new SegmentTree(start);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st.add(hm.get(arr[i]));
            sb.append(st.get_num(hm.get(arr[i]))).append("\n");
//            System.out.println();
        }
        System.out.println(sb);
    }
}

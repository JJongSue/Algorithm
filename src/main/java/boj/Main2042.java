package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2042 {
    static class IndexTree{
        int size;
        int start;
        long tree[];

        public IndexTree(int start) {
            this.start = start;
            this.size = (start << 1);
            this.tree = new long[size+1];
        }
        void setTree(){
            for(int i=start;i>1;i=i>>1){
                for(int j=(i>>1);j<i;j++){
                    tree[j] = tree[(j<<1)] + tree[(j<<1)+1];
                }
            }
        }

        void changeNum(int w, int num){
            int now = start + w - 1;
            long dif = num - tree[now];
            while(now >= 1){
                tree[now] += dif;
                now = (now >> 1);
            }
        }

        long getSum(int left, int right){
            left = start + left - 1;
            right = start + right - 1;
            if(left > right) {
                int tmp = left;
                left =right;
                right = tmp;
            }
            long ret = 0;
            while(left <= right){
                if (left == right) return (ret + tree[left]);
                if(left % 2 == 0) {
                    left = (left >> 1);
                }
                else {
                    ret += tree[left];
                    left = (left >> 1) + 1;
                }

                if(right % 2 == 0) {
                    ret += tree[right];
                    right = (right >> 1) - 1;
                }else {
                    right = (right >> 1);
                }

            }

            return ret;
        }
        void printTree(){
            int now = 1;
            int mul = 2;
            System.out.println();
            for(int i=1;i<size;i++){
                if(i == mul){
                    System.out.println();
                    mul = (mul<<1);
                }
                System.out.print(tree[i]+" ");

            }
            System.out.println();
        }


    }

    static int N, M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int start = 1;
        while(start <= N) start = (start << 1);
        IndexTree it = new IndexTree(start);

        for (int i = 0; i < N; i++) {
            it.tree[i+start] = Integer.parseInt(br.readLine());
        }
        it.setTree();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (M+K); i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1){
                it.changeNum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }else{
//                System.out.println(it.getSum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
                sb.append(it.getSum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
            }

//            it.printTree();
        }
        System.out.println(sb);


    }
}

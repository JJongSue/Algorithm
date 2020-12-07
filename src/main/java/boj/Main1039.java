package boj;

import java.util.HashMap;
import java.util.Scanner;

public class Main1039 {
    static int N, M, K, arr[], dp[][], mul[];
//    static HashMap<>
    static long dododo = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        int tmp = N;
        while(tmp > 0){
            tmp = tmp/10;
            M++;
        }
        arr = new int[M];
        mul = new int[M];
        tmp = N;
        mul[M-1] = 1;
        for(int i=M-1;i>=0;i--){
            if(i != M-1) mul[i] = mul[i+1]*10;
            arr[i] = tmp%10;
            tmp /= 10;
//            System.out.println(arr[i]+ " " + (arr[i]*mul[i]));
        }
        dp = new int[K][1_000_001];
        //System.out.println(mul[0]);
        System.out.println(get_num(0, N));


    }
    static int get_num(int now, int val){
//        System.out.println(dododo++);
        //System.out.println(now + " " + val);
        if(arr[0] == 0) return -1;
        if(now == K){
            return  (val < mul[0] ? -1 :val);
            //if(arr[0] == 0) return -1;
            //return val;
        }
        if(dp[now][val] != 0) return dp[now][val];
        int max = -1;
        for (int i = 0; i < M-1; i++) {
            for (int j = i+1; j < M; j++) {
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
                max = Math.max(max, get_num(now+1, now_num()));
                swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
            }

        }
        return dp[now][val] = max;
    }

    static int now_num(){
        int tmp = 0;
        for (int i = 0; i < M; i++) {
            tmp += (arr[i]*mul[i]);
        }
        return tmp;
    }
}

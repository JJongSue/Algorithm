package boj;

import java.util.Scanner;

public class Main1629 {
    static long arr[] = new long[1_000_001];
    static int A,B,C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        if(A>C) A = A%C;
        System.out.println(calc(B));

    }

    static long calc(int now){
        if(now == 0) return 1;
        if(now == 1) return A;
        if(now < 1_000_001){
            if(arr[now] != 0){
                return arr[now];
            }else{
                long mul = 1;
                if(now%2 == 1) mul = A;
                long num = calc(now>>1);
                long ret = (((num * num) % C ) * mul) % C;
                return arr[now] = ret;
            }
        }
        long mul = 1;
        if(now%2 == 1) mul = A;
        long num = calc(now>>1);
        long ret = (((num * num) % C ) * mul) % C;
        return ret;

    }

}

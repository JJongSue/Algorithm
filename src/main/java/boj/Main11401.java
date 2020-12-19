package boj;

import java.util.Scanner;

public class Main11401 {
    static final int div = 1_000_000_007;
    static long fact[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
//        for (int i = 0; i < 5; i++) {
//            System.out.println(Long.class.isInstance((N-i)));
//        }
        if(N == K || K == 0){
            System.out.println(1);
            return;
        }
        fact = new long[N+1];
        fact[1] = 1;
        for (int i = 2; i <= N; i++) {
            fact[i] = (fact[i-1]*i) % div;
        }
        System.out.println(fact[N]);

        long ans = fact[N];

        long tmp = pow((fact[N-K]), div-2);
        long tmp1 = pow(fact[K], div-2);

        ans = (((ans * tmp) % div) * tmp1) % div;

        System.out.println(ans);


    }
    static long pow(long mul, int p){
        if(p == 0) return 1;
        if(p == 1) return mul;
        long tmp = pow(mul, p/2)%div;
        if(p % 2 == 1){
            return (((tmp*tmp)%div)*mul) % div;
        }
        return (tmp*tmp)%div;

    }
}

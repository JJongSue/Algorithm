package boj;

import java.util.Scanner;

public class Main20444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long K = sc.nextLong();
        if(N == K-1) {
            System.out.println("YES");
            return;
        }

        long l = 0;
        long r = N;//((N+1)>>1);
        long mid = 0;
        while(l<=r){
            mid = (r) -  ((r-l)>>1);
            long tmp = (N+1-mid) * (1+mid);
            System.out.println(mid+ " " + tmp);
            if(tmp == K){
                System.out.println("YES");
                return;
            }
            if(tmp < K){
                l = mid+1;
            }else{
                r = mid-1;
            }


        }
        System.out.println("NO");

    }
}

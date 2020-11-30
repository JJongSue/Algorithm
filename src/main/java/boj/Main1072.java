package boj;

import java.util.Scanner;

public class Main1072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 0 <= Y <= X
        long X = sc.nextLong();
        long Y = sc.nextLong();
        long a = 0 + 10000000;
        long b = 1000000000 + 10000000;
//        int s = (int) ((a * 100) / b ) ;
//        System.out.println(s);
        if(X == 0) {
            System.out.println(1);
            return;
        }

        int winrate = getRate(X, Y);
        long min = 1;
        if(winrate == 100 || winrate == 99) {
            System.out.println(-1);
            return;
        }
        long ans = Long.MAX_VALUE / 1000;//(100*Y - ((winrate+1)*X)) / (winrate - 99);
//        System.out.println(ans);
//        System.out.println(winrate);

        long now = 1;
        int cnt = 0;
        while(min < ans){

            int dif = getRate(X+now, Y+now) - winrate;
//            System.out.println(++cnt + " " + now + " min : " + min + " ans : " + ans+ " dif : "+ dif);
            if(dif > 0) {
                ans = now;
                now = (min + ans) >>> 1;
            }else{
                min = now+1;
                now = (min + ans) >>> 1;
            }
        }
//        System.out.println(min + " " + ans);
        System.out.println(ans);


    }

    static int getRate(long X, long Y){
//        System.out.println("getrate " +(int)((Y * 100) / X));
        return (int)((Y * 100) / X) ;
    }
}

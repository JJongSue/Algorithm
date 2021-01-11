package boj;

import java.util.Scanner;

public class Main1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 666;
        String tmp = "666";
        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j < 100000; j++) {
                if(String.valueOf(ans+j).contains(tmp)){
                    if(i == N){
                        System.out.println(ans);
                    }

                    ans += j;
                    break;

                }
            }
        }
    }
}

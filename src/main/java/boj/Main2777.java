package boj;

import java.util.Scanner;

public class Main2777 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int arr[] = new int[10];
            if(N == 1){
                System.out.println(1);
                continue;
            }
            int div = 2;
            while(N%div == 0){
                N = N/div;
                arr[div]++;
            }

            div = 3;
            while(N%div == 0){
                N = N/div;
                arr[div]++;
            }

            div = 5;
            while(N%div == 0){
                N = N/div;
                arr[div]++;
            }

            div = 7;
            while(N%div == 0){
                N = N/div;
                arr[div]++;
            }

            if(N!=1){
                System.out.println(-1);
                continue;
            }

            int ans = 0;
            div = 2;
            while(arr[2] >= 3){
                arr[2] -= 3;
                arr[8]++;
            }

            while(arr[2]>=2){
                arr[2] -= 2;
                arr[4]++;
            }

            while(arr[2]>=1 && arr[3]>= 1){
                arr[2]--;
                arr[3]--;
                arr[6]++;
            }

            while(arr[3]>=2){
                arr[3] -= 2;
                arr[9]++;
            }
            for (int i = 1; i < 10; i++) {
                ans+=arr[i];
            }
            System.out.println(ans);

        }
    }
}

package boj;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main2624 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int K = sc.nextInt();
        int arr[][] = new int[K][2];
        for (int i = 0; i < K; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        long dp[] = new long[T+1];
        int tmp = arr[0][0];
        int max = 0;
        for (int i = 0; i <= arr[0][1]; i++) {
            if(tmp * i > T) break;
            max = (tmp * i);
            dp[tmp * i] = 1;
        }
        System.out.println(Arrays.toString(dp));

        for (int i = 1; i < K; i++) {
            if(arr[i][0]<T) dp[arr[i][0]]++;
            else break;
            for (int j = arr[i][1]; j >= 1; j--) {
                int start = (T > max+arr[i][0] ? max+arr[i][0] : T);
                max = Math.max(start, max);
//                System.out.println(start);
                for (int k = start; k > (j * arr[i][0]); k--) {
//                    if(j>1 && k== j*arr[i][0]) continue;
                    dp[k] += dp[k-arr[i][0]];


                }
//                System.out.println(Arrays.toString(dp));
            }
            System.out.println(arr[i][0]);
            System.out.println(Arrays.toString(dp));
        }


        System.out.println(Arrays.toString(dp));

        System.out.println(dp[T]);

    }
}

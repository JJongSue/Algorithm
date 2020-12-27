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
//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });

        long dp[][] = new long[K][T+1];
        int tmp = arr[0][0];
        int max = 0;
        for (int i = 0; i <= arr[0][1]; i++) {
            if(tmp * i > T) break;
            max = (tmp * i);
            dp[0][tmp * i] = 1;
        }
//        System.out.println(Arrays.toString(dp[0]));

        for (int i = 1; i < K; i++) {
            int tmpmax = 0;
            for (int j = 0; j <= arr[i][1]; j++) {
                for (int k = 0; k <= max; k++) {
                    if(k+(arr[i][0]*j) > T) break;
                    tmpmax = Math.max(tmpmax, k+(arr[i][0]*j));
                    dp[i][k+(arr[i][0]*j)] += dp[i-1][k];
                }

            }
            max = Math.max(max, tmpmax);
            max = Math.min(max, T);
//            System.out.println(Arrays.toString(dp[i]));
        }


//        System.out.println(Arrays.toString(dp[K-1]));

        System.out.println(dp[K-1][T]);

    }
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int map[] = new int[N];
        int sum = 0;
        int maxnum = -1001;
        int minuscnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            sum += map[i];
            maxnum = Math.max(maxnum, map[i]);
            if(map[i]<0) minuscnt++;
        }
        if(minuscnt >= N-1 ){
            System.out.println(maxnum);
            return;
        }

        if(minuscnt == 0) {
            System.out.println(sum);
            return;
        }

        int minsum = map[0];
        int min = map[0];
        int ans = -1_000_000_000;

        for (int i = 1; i < N; i++) {
            if(minsum > 0) {
                minsum = map[i];
            }else{
                minsum += map[i];
            }
            min = Math.min(min, minsum);
            //ans = Math.max(ans, ())
        }
        System.out.println(sum +" "+ min);
        System.out.println(sum - min);



    }
}

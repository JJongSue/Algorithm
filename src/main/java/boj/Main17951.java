package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int map[][] = new int[N+1][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = map[i-1][1] + map[i][0];
//            System.out.print(map[i][1]+" ");
        }

//        System.out.println(Arrays.toString(map));
        int l = 0;
        int r = (map[N][1]/M);
        int ans = 0;
        while(l <= r){
//            if(l == r){
//
//                break;
//            }
            int mid = ((l+r)>>1);

            int tmpcnt = M;
            boolean is_ans = true;
            int tmpmin = map[N][1];
//            System.out.println(tmpmin);
            int s = 1;
            int e = 1;
//            System.out.println("lr "+l + " " + r);
//            System.out.println("a : "+tmpcnt + " " +mid+ " " + s);
            while(tmpcnt != 1){
                if(map[N][1] - map[s-1][1] < mid) {
                    is_ans = false;
                    break;
                }

                for (e = s; e <= N; e++) {
//                    System.out.println(mid + " "+s + " " + e);
                    if(map[e][1] - map[s-1][1] >= mid){
                        tmpcnt--;
//                        System.out.println(tmpcnt);
                        tmpmin = Math.min(tmpmin, (map[e][1]-map[s-1][1]));
                        s = e+1;
                        break;
                    }
                }
            }
            if(tmpcnt == 1){
                if(map[N][1] - map[s-1][1] >= mid){
//                    System.out.println(tmpmin);
                    tmpmin = Math.min(tmpmin, map[N][1]-map[s-1][1]);
//                    System.out.println(tmpmin);
//                    System.out.println("되나"+ tmpmin);
                    ans = tmpmin;
                    l = tmpmin+1;
                    continue;
                }
            }
            r = mid-1;


        }
        System.out.println(ans);

    }
}

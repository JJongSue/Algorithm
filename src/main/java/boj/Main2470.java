package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans = Math.abs(arr[0]+arr[N-1]);
        int ans1 = arr[0];
        int ans2 = arr[N-1];
        int tmp = 0;
        int mid = 0;
        for (int i = 0; i < N-1; i++) {
            int r = N-1;
            int l = i+1;
            while(l<=r){
                mid = ((l+r) >> 1);
                tmp = arr[mid] + arr[i];
                if(tmp == 0){
                    System.out.println(arr[i] + " " + arr[mid]);
                    return;
                }
                if(Math.abs(tmp) < ans){
                    ans = Math.abs(tmp);
                    ans1 = arr[i];
                    ans2 = arr[mid];
                }
                if(tmp < 0){
                    l = mid+1;
                }else{
                    r = mid-1;
                }

            }

        }
        System.out.println(ans1 + " " + ans2);
    }
}

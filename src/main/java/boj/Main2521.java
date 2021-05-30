package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2521 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        Solution2521 s = new Solution2521();
        System.out.println(s.solution(N, arr, M));

    }
}

class Solution2521{
    int solution(int N, int[] arr, int M){
        int answer = 1;
        long sum = 0;

        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        if(M >= sum) return arr[N-1];
        int l = 1;
        int r = arr[N-1];
//        System.out.println(Arrays.toString(arr));
        while(l<=r){
            int mid = ((l+r) >> 1);
//            System.out.println(l+ " " + r+" " + mid);
            sum = 0;
            for (int i = 0; i < N; i++) {
                if(arr[i] <= mid){
                    sum += arr[i];
                }else{
                    long mul = mid;
                    mul *= ((long)(N-i));
                    sum+= mul;
                    break;
                }
            }
            if(M >= sum){
                answer = mid;
                l = mid+1;
            }else{
                r = mid - 1;
            }
        }
        return answer;
    }
}


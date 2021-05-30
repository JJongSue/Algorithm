package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Solution s = new Solution();
        System.out.println(s.solution(N, arr));

    }

    static class Solution{
        int max_num = (1<<20);
        boolean[] is_visit = new boolean[max_num];
        int solution(int N, int[] arr){
            Arrays.sort(arr);
            for (int i = 0; i < N; i++) {
                if(arr[i] > max_num) break;
                is_visit[arr[i]] = true;
            }
            recur(0,arr, 0, N);
            for (int i = 1; i < max_num; i++) {
                if(!is_visit[i]) return i;
            }
            return max_num;
        }

        void recur(int now, int[] arr, int sum, int N){
            if(now == N || sum > max_num || sum+arr[now] > max_num) return;
            is_visit[arr[now] + sum] = true;
            recur(now+1, arr, sum+arr[now], N);
            recur(now+1, arr, sum, N);
        }
    }
}

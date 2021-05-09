package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main9335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < TC; t++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer>[] al = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                al[i] = new ArrayList<>();
                int cnt = Integer.parseInt(st.nextToken());
                al[i].add(i+1);
                for (int j = 0; j < cnt; j++) {
                    al[i].add(Integer.parseInt(st.nextToken()));
                }
            }
            Solution9335 s = new Solution9335();
            sb.append(s.solution(n, al)).append('\n');
        }
        System.out.println(sb);

    }
}
class Solution9335{
    int cmp = 0;
    int n;
    int[] bitmap;
    int solution(int n, ArrayList<Integer>[] al){
        int answer = n;
        this.n = n;
        cmp = (1<<n)-1;
        bitmap = new int[n];

        for (int i = 0; i < n; i++) {
            for (int tmp: al[i]) {
                bitmap[i] |= (1<<(tmp-1));
            }
            if(bitmap[i] == cmp) return 1;
        }
        for (int i = 2; i < n; i++) {
            if(combi(0,0,i,0)) return i;
        }

        return answer;
    }
    boolean combi(int now, int now_cnt, int cnt, int sum){
        if(now_cnt == cnt){
            if(sum == cmp) return true;
            return false;
        }
        if(now >= n) return false;
        return (combi(now+1, now_cnt+1, cnt, (sum|bitmap[now]))) | combi(now+1, now_cnt, cnt, sum);


    }

}

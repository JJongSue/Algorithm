package boj;
import java.util.Scanner;

public class Main10819 {
    static int N, arr[], ans = 0;
    static boolean is_visit[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        is_visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            is_visit[i] = true;
            get_num(1, arr[i], 0);
            is_visit[i] = false;
        }
        System.out.println(ans);

    }

    static void get_num(int now, int last, int sum){
        if(now == N) {
            ans = Math.max(ans, sum);
            return;
        }
        for(int i=0;i<N;i++){
            if(!is_visit[i]){
                is_visit[i] = true;
                get_num(now+1, arr[i], sum+Math.abs(last - arr[i]));
                is_visit[i] = false;
            }
        }
    }
}

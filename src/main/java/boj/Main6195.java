package boj;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main6195 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            long tmp = sc.nextLong();
//            sum += tmp;
            pq.add(tmp);
        }
        long ans = 0;
        int last = 0;
        while(pq.size() != 1){
            long first = pq.poll();
            long second = pq.poll();
            long sum = first + second;
            ans += sum;
            pq.add(sum);
        }
        System.out.println(ans);
    }
}

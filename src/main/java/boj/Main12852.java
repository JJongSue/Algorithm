package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main12852 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N == 1) {
            System.out.println("0\n1");
            return;
        }
        int map[][] = new int[N+1][2];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
//        map[1][1] = 1;
        while(!q.isEmpty()){
            int now = q.poll();

            int next = now*3;
            if(next <= N && map[next][0] == 0){
                map[next][0] = map[now][0]+1;
                map[next][1] = now;
                q.add(next);
                if(next == N) break;
            }
            next = now*2;
            if(next <= N && map[next][0] == 0){
                map[next][0] = map[now][0]+1;
                map[next][1] = now;
                q.add(next);
                if(next == N) break;
            }
            next = now+1;
            if(next <= N && map[next][0] == 0){
                map[next][0] = map[now][0]+1;
                map[next][1] = now;
                q.add(next);
                if(next == N) break;
            }
        }
        System.out.println(map[N][0]);
        int now = N;
        while(now != 0){
            System.out.print(now + " ");
            now = map[now][1];
        }
    }
}

package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main17071 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        if(N == K){
            System.out.println(0);
            return;
        }

        int tmax = 0;
        int tmap[] = new int[500_001];

        for (int i = 1; i < 500_001; i++) {
            if(K+i > 500_000) break;
            K += i;
            tmap[K] = i;
            tmax = i;
        }

        Queue<Integer> q = new LinkedList<>();
//        System.out.println(tmap[16]);
        q.add(N);
        int ans = -1;
        if(tmap[N] != 0 && tmap[N] % 2 == 0) {
//            System.out.println(tmap[N]);
            ans = tmap[N];

        }
        int smap[][] = new int[500_001][2];
        int tnext = 0;
        int size = 0;
        int now = 0;
        int tmpnow = 0;
        for (int i = 0; i <= tmax; i++) {
//            System.out.println(i);
            tnext = i+1;
            size = q.size();
            for (int s = 0; s < size; s++) {
                now = q.poll();
//                System.out.println(now);
                tmpnow = now-1;
                if(tmpnow>=0 && smap[tmpnow][tnext%2] == 0){
                    if(tmap[tmpnow] >= tnext && tmap[tmpnow] % 2 == (tnext%2)){
                        if(ans == -1) ans = Math.max(tnext, tmap[tmpnow]);
                        else{
                            ans = Math.min(ans, Math.max(tnext, tmap[tmpnow]));

                        }
                    }
                    smap[tmpnow][tnext%2] = tnext;
                    q.add(tmpnow);
                }

                tmpnow = now+1;
                if(tmpnow<=500_000 && smap[tmpnow][tnext%2] == 0){
                    if(tmap[tmpnow] >= tnext && tmap[tmpnow] % 2 == (tnext%2)){
                        if(ans == -1) ans = Math.max(tnext, tmap[tmpnow]);
                        else{
                            ans = Math.min(ans, Math.max(tnext, tmap[tmpnow]));

                        }
                    }
                    smap[tmpnow][tnext%2] = tnext;
                    q.add(tmpnow);
                }

                tmpnow = (now<<1);
                if(tmpnow<=500_000 && smap[tmpnow][tnext%2] == 0) {
                    if (tmap[tmpnow] >= tnext && tmap[tmpnow] % 2 == (tnext % 2)) {
                        if(ans == -1) ans = Math.max(tnext, tmap[tmpnow]);
                        else{
                            ans = Math.min(ans, Math.max(tnext, tmap[tmpnow]));
                        }
                    }
                    smap[tmpnow][tnext % 2] = tnext;
                    q.add(tmpnow);
                }
            }


        }

        System.out.println(ans);


    }
}

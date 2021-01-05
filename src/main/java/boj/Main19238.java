package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main19238 {
    static final int dx[] = {0,1,0,-1};
    static final int dy[] = {-1,0,1,0};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int ans = Integer.parseInt(st.nextToken());

        int map[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if(st.nextToken().charAt(0) == '1') map[i][j] = -1;
            }
        }
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken())-1;
        int x = Integer.parseInt(st.nextToken())-1;
        int desx = 0;
        int desy = 0;
        dot now = new dot(x,y, 0);


        int dis = 0;
        dot customers[] = new dot[M+1];
        dot dess[] = new dot[M+1];
        Queue<dot> q;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            boolean is_visit[][] = new boolean[N][N];
            q = new LinkedList<>();
            y = Integer.parseInt(st.nextToken())-1;
            x = Integer.parseInt(st.nextToken())-1;
            map[y][x] = i;
            desy = Integer.parseInt(st.nextToken())-1;
            desx = Integer.parseInt(st.nextToken())-1;
            dess[i-1] = new dot(desx, desy, 0);
            is_visit[y][x] = true;
            customers[i-1] = new dot(x,y, 0);
            q.add(customers[i-1]);
            dis = 1;
            boolean is_ok = false;
            end:while(!q.isEmpty()){
//                System.out.println(dis);
                int size = q.size();
                for (int s = 0; s < size; s++) {
//                    System.out.println(s);
                    x = q.peek().x;
                    y = q.peek().y;
                    q.poll();



                    for (int j = 0; j < 4; j++) {
                        int xx = x+dx[j];
                        int yy = y+dy[j];
                        if(is_map(xx,yy) && !is_visit[yy][xx] && map[yy][xx] != -1){
                            if(yy == desy && xx==desx){
                                is_ok = true;
                                break end;
                            }

                            q.add(new dot(xx,yy,0));
                            is_visit[yy][xx] = true;
                        }
                    }


                }
                dis++;
            }
            customers[i-1].dis = dis;
            if(!is_ok){
                System.out.println(-1);
                return;
            }



        }

        int cnt = M;
        while(cnt != 0){
            q = new LinkedList<>();
            q.add(now);
            dis = 0;
            boolean is_go[] = new boolean[M];
            boolean is_end = false;
            boolean is_visit[][] = new boolean[N][N];
            while(!q.isEmpty()){
                int size = q.size();
                for (int s = 0; s < size; s++) {
                    x = q.peek().x;
                    y = q.poll().y;
                    if(map[y][x] != 0){
                        is_go[map[y][x]-1] = true;
                        is_end = true;
                    }
                    if(is_end) continue;
                    for (int i = 0; i < 4; i++) {
                        int xx = x+dx[i];
                        int yy = y+dy[i];
                        if(is_map(xx,yy) && !is_visit[yy][xx] && map[yy][xx] != -1){
                            q.add(new dot(xx,yy,0));
                            is_visit[yy][xx] = true;
                        }
                    }

                }
                if(is_end) break;
                dis++;
            }
            if(!is_end){
                System.out.println(-1);
                return;
            }
            int minx = N+1;
            int miny = N+1;
            int num = 0;
            for (int i = 0; i < M; i++) {
                if(is_go[i]){
                    if(customers[i].y < miny){
                        minx = customers[i].x;
                        miny = customers[i].y;
                        num = i;
                    }else if(customers[i].y == miny){
                        if(customers[i].x < minx){
                            minx = customers[i].x;
                            miny = customers[i].y;
                            num = i;
                        }
                    }
                }
            }
//            System.out.println("dis");
//            System.out.println(now.x + " " + now.y + " " + ans+ " ");
//            System.out.println(dis+" " + customers[num].dis + " " +(dis + customers[num].dis));
            if(dis + customers[num].dis > ans) {
                System.out.println(-1);
                return;
            }
            cnt--;
            ans -= dis;
            ans += ((customers[num].dis));
            now.x = minx;

            map[customers[num].y][customers[num].x] = 0;
            customers[num].x = -1;
            customers[num].y = -1;
            now.x = dess[num].x;
            now.y = dess[num].y;


        }
        System.out.println(ans);



    }
    static boolean is_map(int x, int y){
        if(x >= N || y>= N || x<0 || y<0) return false;
        return true;
    }

}

class dot{
    int x;
    int y;
    int dis;
    public dot(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

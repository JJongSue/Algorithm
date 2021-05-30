package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1991 {
    public static void main(String[] args) throws IOException {
        Node[] node;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        node = new Node[N];
        for (int i = 0; i < N; i++) {
            node[i] = new Node((char)(i+'A'));
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int now = st.nextToken().charAt(0) - 'A';
            int l = st.nextToken().charAt(0) - 'A';
            int r = st.nextToken().charAt(0) - 'A';
            if(l >= 0){
                node[now].l = node[l];
                node[l].p = node[now];
            }
            if( r>= 0){
                node[now].r = node[r];
                node[r].p = node[now];
            }
        }
        StringBuilder sb = new StringBuilder();
        Deque<Node> q = new LinkedList<>();
        q.add(node[0]);
        while(!q.isEmpty()){
            Node now = q.poll();
            sb.append(now.val);
            if(now.r != null) q.addFirst(now.r);
            if(now.l != null) q.addFirst(now.l);
        }
        sb.append('\n');
        boolean[] is_visit = new boolean[N];
        q.add(node[0]);
        while(!q.isEmpty()){
            Node now = q.pollFirst();
            if(is_visit[now.val - 'A']){
                sb.append(now.val);
                continue;
            }
            is_visit[now.val - 'A'] = true;
            if(now.r != null) q.addFirst(now.r);
            q.addFirst(now);

            if(now.l != null) q.addFirst(now.l);


        }
        sb.append('\n');
        is_visit = new boolean[N];
        q.add(node[0]);
        while(!q.isEmpty()){
            Node now = q.pollFirst();
            if(is_visit[now.val - 'A']){
                sb.append(now.val);
                continue;
            }
            is_visit[now.val - 'A'] = true;
            q.addFirst(now);
            if(now.r != null) q.addFirst(now.r);
            if(now.l != null) q.addFirst(now.l);


        }


        System.out.println(sb);

    }
    static class Node{
        Node l;
        Node r;
        Node p;
        char val;

        public Node(char val) {
            this.val = val;
        }

        public Node(Node l, Node r, Node p, char val) {
            this.l = l;
            this.r = r;
            this.p = p;
            this.val = val;
        }
    }
}

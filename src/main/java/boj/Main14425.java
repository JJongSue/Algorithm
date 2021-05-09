package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14425 {
    static class Trie{
        Node map[];

        public Trie() {
            map = new Node[26];
        }
        public void insert(String str){
            Node now = map[str.charAt(0) - 'a'];
            if(now == null){
                map[str.charAt(0) - 'a'] = new Node();
                now = map[str.charAt(0) - 'a'];
            }
            for (int i = 1; i < str.length(); i++) {
//                System.out.println(i);
                int go = str.charAt(i) - 'a';
                if(now.next[go] == null){
                    now.next[go] = new Node();
                }
                if(i == str.length()){
                    now.is_in =true;
                    return;
                }
                now = now.next[go];
            }

        }
        public boolean is_In(String str){
            Node now = map[str.charAt(0) - 'a'];
            if(now == null) return false;
//            System.out.print(str + " "+str.length()+" ");
            for (int i = 1; i < str.length(); i++) {
                int go = str.charAt(i) - 'a';
                if(now.next[go] == null){
                    return false;
                }
//                System.out.print(i+" ");

                now = now.next[go];
            }

            if(now.is_in) return true;
            return false;
        }
    }
    static class Node{
        boolean is_in = false;
        Node next[];

        public Node() {
            this.next = new Node[26];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Trie t = new Trie();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            t.insert(str);
        }
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            boolean is_ok = t.is_In(str);
            if(is_ok) cnt++;
//            System.out.println(" "+is_ok);
        }
        System.out.println(cnt);
    }
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Queue<Integer> q = new LinkedList<>();
        Queue<Character> q2 = new LinkedList<>();
        int ans = 0;
        end:for(int i=0;i<str.length();i++){
            int now = 0;
            for(int j=i;j<str.length();j++){
                if(str.charAt(j) != '+' && str.charAt(j) != '-'){
                    now = (now*10) + (str.charAt(j) - '0');
                    if(j == str.length()-1) {
                        q.add(now);
                        break end;
                    }
                }else{
                    q.add(now);
                    i = j;
                    q2.add(str.charAt(i));
                    break;
                }
            }
        }
//        System.out.println(q.peek());
        ans = q.poll();
//        System.out.println(ans);

//        while(!q.isEmpty()) System.out.println(q.poll());

        while(!q2.isEmpty()){
            if(q2.peek() == '+'){
                q2.poll();
//                System.out.println(q.peek());
                ans += q.poll();
            }else{
                ans -= q.poll();
                q2.poll();
//                System.out.println(ans);
                while(!q2.isEmpty() && q2.peek() == '+'){
                    q2.poll();
                    ans -= q.poll();
//                    System.out.println(ans);
                }
            }
        }
        System.out.println(ans);

    }
}

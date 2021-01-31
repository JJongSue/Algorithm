package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(0).append(' ');
        Stack<Top> stack = new Stack<>();
        stack.add(new Top(1, Integer.parseInt(st.nextToken())));
        for (int i = 2; i <= N; i++) {
            int h = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() ){
                if(stack.peek().h > h ) break;
                stack.pop();
            }

            if(stack.isEmpty()){
                sb.append(0).append(' ');
                stack.add(new Top(i, h));
            }else{
                sb.append(stack.peek().N).append(' ');
                stack.add(new Top(i, h));
            }


        }
        System.out.println(sb);
    }

}
class Top{
    int N;
    int h;

    public Top(int n, int h) {
        N = n;
        this.h = h;
    }
}

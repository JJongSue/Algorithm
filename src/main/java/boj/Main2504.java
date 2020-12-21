package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '[' ){
                st.add((int)ch);
            }else if(ch == ')'){
                if(st.isEmpty()) {
                    System.out.println(0);
                    return;
                }
                if(st.peek() == '('){
                    st.pop();
                    st.add(-2);
                }else if(st.peek() < 0){
                    int sum = st.pop();
                    boolean end = false;
                    while(!st.isEmpty()){
                        int now = st.pop();
                        if(now == '('){
                            sum *= 2;
                            st.add(sum);
                            end = true;
                            break;
                        }else if(now < 0){
                            sum += now;
                        }else{
                            System.out.println(0);
                            return;
                        }
                    }
                    if(!end) {
                        System.out.println(0);
                        return;
                    }
                }

            }else{
                if(st.isEmpty()) {
                    System.out.println(0);
                    return;
                }
                if(st.peek() == '['){
                    st.pop();
                    st.add(-3);
                }else if(st.peek() < 0){
                    int sum = st.pop();
                    boolean end = false;
                    while(!st.isEmpty()){
                        int now = st.pop();
                        if(now == '['){
                            end = true;
                            sum *= 3;
                            st.add(sum);
                            break;
                        }else if(now < 0){
                            sum += now;
                        }else{
                            System.out.println(0);
                            return;
                        }
                    }
                }

            }

        }
        int ans = 0;
        while(!st.isEmpty()){
            if(st.peek() > 0) {
                System.out.println(0);
                return;
            }
            ans += st.pop();
        }
        ans *= -1;
        System.out.println(ans);

    }
}

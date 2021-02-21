package KakaoBlind.y2019winter;
import java.util.Stack;


class Solution1 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        Stack<Integer> st[] = new Stack[N+1];
        for(int i=0;i<N;i++) {
            st[i] = new Stack<>();
            for(int j=N-1;j>=0;j--) {
                if(board[j][i] != 0) st[i].add(board[j][i]);
            }
//        	System.out.println(st[i].size());
        }
        st[N] = new Stack<>();
        for(int i=0;i<moves.length;i++) {
            int tmp = moves[i]-1;
            if(!st[tmp].isEmpty()) {
                int input = st[tmp].pop();
                if(!st[N].isEmpty()) {
                    if(st[N].peek() == input) {

                        st[N].pop();
                        answer += 2;
                    }else {
                        st[N].add(input);
                    }
                }else {
                    st[N].add(input);
                }
            }
        }


        return answer;
    }
}
package KakaoBlind.y2019winter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;
class Solution2 {
    public int[] solution(String s) {
        Stack<Integer> stack = new Stack<>();
        int size = 0;
        int[] answer = null;
        StringTokenizer st = new StringTokenizer(s,"{");
        ArrayList<String> al = new ArrayList<>();
        int cnt = st.countTokens();
//		st.nextToken();
        for(int i=0;i<cnt;i++) {
            String sss = st.nextToken();
//			System.out.println(sss);
            StringTokenizer st2 = new StringTokenizer(sss, "}");
            String ssss = st2.nextToken();
            StringTokenizer st3 = new StringTokenizer(ssss, ",");
            //System.out.println(ssss);
            al.add(ssss);

        }
        al.sort(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                // TODO Auto-generated method stub
                return o1.length() - o2.length();
            }
        });
        boolean is_visit[] = new boolean[100_001];
//		int size = 0;
        st = new StringTokenizer(al.get(al.size()-1), ",");
        size = st.countTokens();
        answer = new int[size];
        for(int i=0;i<al.size();i++) {
            st = new StringTokenizer(al.get(i), ",");
            int tmp = st.countTokens();
            for(int j=0;j<tmp;j++) {
                int input = Integer.parseInt(st.nextToken());
                if(!is_visit[input]) {
                    answer[i] = input;
                    is_visit[input] = true;
                    break;
                }
            }
        }




        return answer;
    }
}
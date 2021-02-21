package KakaoBlind.y2019winter;

import java.util.ArrayList;

class Solution3 {
    static int answer = 0;
    static boolean is_visit[];
    static ArrayList<Integer> al[];
    static boolean map[] = new boolean[1<<9];
    static public int solution(String[] user_id, String[] banned_id) {

        if(user_id.length == banned_id.length) return 1;
        is_visit = new boolean[user_id.length];

        al = new ArrayList[banned_id.length];
        for(int i=0;i<banned_id.length;i++) {
            al[i] = new ArrayList<>();
            for(int j=0;j<user_id.length;j++) {
                if(user_id[j].length() == banned_id[i].length()) {
                    boolean is_ok = true;
                    for(int k=0;k<banned_id[i].length();k++) {
                        if(banned_id[i].charAt(k) != user_id[j].charAt(k) && banned_id[i].charAt(k) != '*'){
                            is_ok = false;
                            break;
                        }

                    }
                    if(is_ok) al[i].add(j);
                }
            }
//        	System.out.println(al[i].size());
        }
        select(0, banned_id.length, 0);


        return answer;
    }
    static void select(int now, int N, int dp) {
        if(now == N) {
//			System.out.println(Arrays.toString(d));
            if(!map[dp]) {

                answer++;
                map[dp] = true;
            }
            return;
        }
        for(int i=0;i<al[now].size();i++) {
            if(!is_visit[al[now].get(i)]) {
                is_visit[al[now].get(i)] = true;
                select(now+1, N, (dp|(1<<al[now].get(i))));
                is_visit[al[now].get(i)] = false;
            }
        }
//		select(now+1, N, dp);
    }
}
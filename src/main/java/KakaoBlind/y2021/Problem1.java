package KakaoBlind.y2021;

import java.util.LinkedList;

/***
 * 신규 아이디 추천
 */
public class Problem1 {
    public static void main(String[] args) {

    }
}
class Solution1 {
    public String solution(String new_id) {
        LinkedList<Character> ll = setString(new_id);
        removeFirst(ll);
        removeLast(ll);
        if(ll.isEmpty()) ll.add('a');
        setLength(ll);

        String answer = new String();
        while(ll.isEmpty()){
            answer += ll.pollFirst();
        }

        return answer;
    }
    /***
     * String -> LinkedList
     * 1,2,3과정
     * 대 -> 소
     * a-z, 0-9, -, _, . 문자만 넣기
     * ..연속시 .한번만
     */
    LinkedList<Character> setString(String new_id){
        LinkedList<Character> ll = new LinkedList<>();
        for (char c : new_id.toCharArray()) {
            if('A' <= c && c<= 'Z') ll.add( (char)(c-'A'+'a') );
            else if( ('a'<= c && c <= 'z') || ( '0'<= c && c<= '9') || c == '-' || c =='_' ) ll.add(c);
            else if( c == '.'){
                if(!ll.isEmpty() && ll.peekLast() == '.') continue;
                ll.add(c);
            }
        }

        return ll;
    }

    /***
     * . 처음에 있을때 제거
     */
    void removeFirst(LinkedList<Character> ll){
        while(!ll.isEmpty()){
            if(ll.peekFirst() == '.') ll.pollFirst();
            else return;
        }
    }

    /***
     * . 끝에 있을때 제거
     */
    void removeLast(LinkedList<Character> ll){
        while(!ll.isEmpty()){
            if(ll.peekLast() == '.') ll.pollLast();
            else return;
        }
    }

    void setLength(LinkedList<Character> ll){
        while(ll.size() > 15){
            ll.pollLast();
        }
        removeLast(ll);

        while(ll.size() < 3){
            ll.add(ll.peekLast());
        }
    }

}

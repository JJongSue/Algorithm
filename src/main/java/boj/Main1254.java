package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int max = str.length() * 2;
        int size = str.length();
        if(str.length() == 1) {
            System.out.println(1);
            return;
        }
        int start = size / 2;
        if(size % 2 == 1) start++;

        for(int i=start;i<size;i++){
            int cnt = 0;
            boolean is_ok = true;
            for(int j=0;i+j<size;j++){
                if(str.charAt(i+j) != str.charAt(i-j-1)){
                    is_ok = false;
                    break;
                }
                cnt++;
            }
            if(is_ok){
                max = Math.min(max, (size + size - (cnt * 2)));
//                System.out.println("1 "+i+ " " + max);
                break;
            }
        }
        start = size / 2;
//        if(size % 2 == 0) start--;

        for(int i=start;i<size;i++){
            int cnt = 0;
            boolean is_ok = true;
            for(int j=1;i+j<size;j++){
                if(str.charAt(i+j) != str.charAt(i-j)){
                    is_ok = false;
                    break;
                }
                cnt++;
            }
            if(is_ok){
                max = Math.min(max, (size + size - ((cnt*2)+1)));
//                System.out.println("1 "+i+ " " + max);
                break;
            }

        }
        System.out.println(max);



    }
}

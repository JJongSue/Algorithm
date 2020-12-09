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
        for(int i=size/2;i<size;i++){
            boolean is_ok = true;
            //자기자신비교
            int cnt = 0;
            for(int j=0;i+j<size;j++){
                cnt++;
                if(str.charAt(i+j) != str.charAt(i-j-1)) {
                    is_ok = false;
                    break;
                }
            }
            if(is_ok){
                max = Math.min(max, size+size-(cnt*2));
            }
        }

    }
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main1744 {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> plus = new ArrayList<Integer>();
        ArrayList<Integer> minus = new ArrayList<Integer>();
        int zero = 0;
        int one = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp  = Integer.parseInt(br.readLine());
            if(tmp < 0) minus.add(tmp);
            else if(tmp == 0) zero++;
            else if(tmp == 1) one++;
            else plus.add(tmp);
        }
        int ans = one;
        plus.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        minus.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
//        System.out.println(plus.toString());
//        System.out.println(minus.toString());

        if(plus.size()%2 == 0){
            for(int i=0;i<plus.size();i=i+2){
                ans += (plus.get(i) * plus.get(i+1));
            }
        }else{
            ans += plus.get(0);
            for(int i=1;i<plus.size();i=i+2){
                ans += (plus.get(i) * plus.get(i+1));
            }
        }

        if(minus.size()%2 == 0){
            for(int i=0;i<minus.size();i=i+2){
                ans += (minus.get(i) * minus.get(i+1));
            }
        }else{
            if(zero == 0) ans += minus.get(minus.size()-1);
            for(int i=0;i+1<minus.size();i=i+2){
                ans += (minus.get(i) * minus.get(i+1));
            }
        }
        System.out.println(ans);


    }
}

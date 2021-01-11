package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char map[] = new char[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map[ch-'A']++;
        }
        int ans = 0;
        char map2[] = new char[26];
        for (int i = 1; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                map2[ch-'A']++;

            }

            int dif = 0;
            int sum = 0;
            for (int j = 0; j < 26; j++) {
                dif += (Math.abs(map[j]-map2[j]));
                sum += (map[j]-map2[j]);
                //max = Math.max(Math.abs( map[j]-map2[j] ), max);
                map2[j] = 0;
            }
            if(dif <= 1 || (dif == 2 && sum == 0) ) ans++;

        }
        System.out.println(ans);

    }
}

package KakaoBlind.y2021;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem5 {
    public static void main(String[] args) {
//        String play_time = "02:03:55";
//        String adv_time ="00:14:15";
//        String logs[] = {
//                "01:20:15-01:45:14",
//                "00:40:31-01:00:00",
//                "00:25:50-00:48:29",
//                "01:30:59-01:53:29",
//                "01:37:44-02:02:30"
//        };
//        String play_time = "00:00:03";
//        String adv_time ="00:00:01";
//        String logs[] = {
//                "00:00:00-00:00:01",
//                "00:00:00-00:00:01",
//                "00:00:01-00:00:02",
//                "00:00:01-00:00:02",
//                "00:00:01-00:00:03"
//        };
//        String play_time = "99:59:59";
//        String adv_time ="00:00:03";
//        String logs[] = new String[300_000];
//        for (int i = 0; i < logs.length; i++) {
//            logs[i] = "00:00:03-00:00:04";
//        }
        String play_time = "99:59:59";
        String adv_time ="25:00:00";
        String logs[] = {
                "69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"
        };

//        String play_time = "01:03:55";
//        String adv_time ="00:14:15";
//        String logs[] = {
//                "00:20:15-00:45:14",
//
//        };


        System.out.println(new Solution5().solution(play_time, adv_time, logs));

    }
}
class Solution5 {
    long timestamp[];
    int logmap[][];
    int adv;
    int maxtime;
    int ss, ee;

    public String solution(String play_time, String adv_time, String[] logs) {
        maxtime = getTime(play_time);

        timestamp = new long[maxtime+1];

        adv = getTime(adv_time);
        int s = 0;
        int e = 0;
        for (int i = 0; i < logs.length; i++) {
//            getTime2(logs[i]);
            ss=0;
            ss += (( (logs[i].charAt(0))-'0'  ) * 10 + (logs[i].charAt(1)-'0')) * 3600;
            ss += (( (logs[i].charAt(3))-'0'  ) * 10 + (logs[i].charAt(4)-'0')) * 60;
            ss += (( (logs[i].charAt(6))-'0'  ) * 10 + (logs[i].charAt(7)-'0')) ;
            ee=0;
            ee += (( (logs[i].charAt(9))-'0'  ) * 10 + (logs[i].charAt(10)-'0')) * 3600;
            ee += (( (logs[i].charAt(12))-'0'  ) * 10 + (logs[i].charAt(13)-'0')) * 60;
            ee += (( (logs[i].charAt(15))-'0'  ) * 10 + (logs[i].charAt(16)-'0')) ;
            timestamp[ss]++;
//            System.out.println(ss + " " + ee);
//            if(ee+1 <= maxtime) timestamp[ee+1]--;

            timestamp[ee]--;
//            for (int t = ss; t <= ee; t++) {
//                timestamp[t]++;
//            }
        }
//        System.out.println(Arrays.toString(timestamp));
        for (int i = 1; i <= maxtime; i++) {
            timestamp[i] += timestamp[i-1];
        }
//        System.out.println(Arrays.toString(timestamp));



        return getAns();
    }

    int getTime(String time){
        int ret = 0;
        ret += (( (time.charAt(0))-'0'  ) * 10 + (time.charAt(1)-'0')) * 3600;
        ret += (( (time.charAt(3))-'0'  ) * 10 + (time.charAt(4)-'0')) * 60;
        ret += (( (time.charAt(6))-'0'  ) * 10 + (time.charAt(7)-'0')) ;

        return ret;
    }




    String getAns(){
        int ans = 0;
        long now = 0;
//        for (int i = 0; i <= adv; i++) {
//            now += timestamp[i];
//        }
        for(int i=1;i<=maxtime;i++){
            timestamp[i] += timestamp[i-1];
        }

        long maxcnt = timestamp[adv];
        now = timestamp[adv];

        for (int i = adv+1; i <= maxtime ; i++) {
            now = timestamp[i] - timestamp[i-adv];
//            now += timestamp[i+adv];
            if(now > maxcnt){
//                System.out.println(now + " " + ans + " " + maxcnt+" "+ (i-adv));
                maxcnt = now;
                ans = i-adv+1;
            }
            if(now == maxcnt){
//                System.out.println((i-adv) + " " + now);
                String str = "";


                int input = (i-adv) / 3600;

                if(input < 10) str += ("0" + Integer.toString(input));
                else str += Integer.toString(input);
//                ans %= 3600;

                str += ":";

                input = ((i-adv)%3600) / 60;

                if(input < 10) str += ("0" + Integer.toString(input));
                else str += Integer.toString(input);
//                ans %= 60;

                str += ":";
                input = ((i-adv)%3600)%60;

                if(input < 10) str += ("0" + Integer.toString(input));
                else str += Integer.toString(input);

//                System.out.println(str+ " " + now + " " + maxcnt);
            }

        }

        String str = "";


        int input = ans / 3600;

        if(input < 10) str += ("0" + Integer.toString(input));
        else str += Integer.toString(input);
        ans %= 3600;

        str += ":";

        input = ans / 60;

        if(input < 10) str += ("0" + Integer.toString(input));
        else str += Integer.toString(input);
        ans %= 60;

        str += ":";
        input = ans;

        if(input < 10) str += ("0" + Integer.toString(input));
        else str += Integer.toString(input);

//        System.out.println(Arrays.toString(timestamp));
//        System.out.println(timestamp[2]);
//        System.out.println(timestamp[100]);

        return str;
    }




}
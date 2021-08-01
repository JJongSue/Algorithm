package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main7578 {
    public static void main(String[] args) throws IOException {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            hashMap.put(Integer.parseInt(stringTokenizer.nextToken()), i);
        }
        int indexSize = 1;
        while(indexSize <= N){
            indexSize = (indexSize<<1);
        }
        int start = indexSize;
        indexSize = (indexSize << 1);
        long[] indexTree = new long[indexSize];
        long answer = 0;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(stringTokenizer.nextToken());
            int now = hashMap.get(input);
            answer += getSum(indexTree, start+now, start+N);
            setTree(indexTree, start+now);
        }
        System.out.println(answer);



    }
    static long getSum(long[] indexTree, int left, int right){
        long sum = 0;
        while(left <= right){
            if(left == right) {
                return sum + indexTree[left];
            }
            if(left % 2 == 1) {
                sum += indexTree[left];
                left++;
            }
            if(right % 2 == 0){
                sum += indexTree[right];
                right--;
            }
            left = (left >> 1);
            right = (right >> 1);
        }
        return sum;
    }
    static void setTree(long[] indexTree, int now){
        while(now >= 1){
            indexTree[now]++;
            now = (now>>1);
        }
    }
}

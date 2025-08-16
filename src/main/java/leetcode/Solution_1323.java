package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-69-number/description/
 * LeetCode Problem 1323: Maximum 69 Number
 *
 * Given a positive integer num consisting only of digits 6 and 9, return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 *
 * Example:
 * Input: num = 9669
 * Output: 9969
 */
public class Solution_1323 {
    public static int maximum69Number(int num) {
        List<Integer> list = new ArrayList<Integer>();
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
        boolean isChanged = false;
        num = 0;
        for (int i = list.size() - 1; i >= 0 ; i--) {
            if(!isChanged && list.get(i) == 6) {
                list.set(i, 9);
                isChanged = true;
            }
            num = num * 10 + list.get(i);
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
        System.out.println(maximum69Number(9999));
        System.out.println(maximum69Number(9996));
        System.out.println(maximum69Number(6666));


    }
}

package programming2020.leetcode.april_challenge;

import java.util.HashSet;

public class HappyNumber {


    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    public static HashSet<Integer> set = new HashSet();

    public static boolean isHappy(int n) {
        if (set.contains(n)) return false;
        set.add(n);
        char arr[] = String.valueOf(n).toCharArray();
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i] - '0';
            num += a * a;
        }
        if (1 == num) {
            return true;
        } else return isHappy(num);

    }
}

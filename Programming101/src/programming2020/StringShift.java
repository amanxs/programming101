package programming2020;

/**
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:

 direction can be 0 (for left shift) or 1 (for right shift).
 amount is the amount by which string s is to be shifted.
 A left shift by 1 means remove the first character of s and append it to the end.
 Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 Return the final string after all operations.



 Example 1:

 Input: s = "abc", shift = [[0,1],[1,2]]
 Output: "cab"
 Explanation:
 [0,1] means shift to left by 1. "abc" -> "bca"
 [1,2] means shift to right by 2. "bca" -> "cab"
 Example 2:

 Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 Output: "efgabcd"
 Explanation:
 [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 */
public class StringShift {

    public static void main(String[] args) {
        StringShift shift = new StringShift();
        int shifts[][] = {{0,1},{1,2}};
        String s = shift.stringShift("abc", shifts);
        System.out.println(s);
    }
    public String stringShift(String s, int[][] shifts) {
        for (int shift[] : shifts) {
            switch (shift[0]) {
                case 0:
                    s = leftShift(s, shift[1]);
                    break;
                case 1:
                    s = rightShift(s, shift[1]);
                    break;
            }
        }
        return s;
    }

    private String rightShift(String s, int n) {
        return leftShift(s, s.length() - n);
    }

    public static String leftShift(String s, int n) {
        String str = s.substring(n) + s.substring(0, n );
        return str;
    }

}
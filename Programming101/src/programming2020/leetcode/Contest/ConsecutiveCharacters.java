package programming2020.leetcode.Contest;

public class ConsecutiveCharacters {
    public static void main(String[] args) {
        String s = "abbcccddddeeeeedcba";

        System.out.println(maxPower(s));
        //Output: 2
    }
    public static int maxPower(String s) {
        char arr[] = s.toCharArray();
        int curr = 0;
        int max = 0;
        char currChar = arr[0];
        for(int i =1; i< arr.length; i++){
            if(arr[i] == currChar){
                curr++;
                max = Math.max(curr, max);

            }
            else{
                currChar = arr[i];
                curr = 1;
            }
        }

        return max;

    }
}

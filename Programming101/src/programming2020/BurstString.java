package programming2020;

import java.util.Stack;

public class BurstString {
    /*
    Given an input String return a String with no consecutive character
    Ex :
    Input : geegsfaaf
    output : s
     */

    public static void main(String[] args) {
        burstString("geegsfaaf");
    }

    private static void burstString(String str) {
        Stack<Character> stack = new Stack<>();
        char arr[] = str.toCharArray();

        for(int i =0; i< arr.length; i++){
            if (!stack.isEmpty() && arr[i] == stack.peek()){
                stack.pop();
            }
            else{
                stack.push(arr[i]);
            }
        }
        for(Character c : stack){
            System.out.println(c);
        }
    }
}

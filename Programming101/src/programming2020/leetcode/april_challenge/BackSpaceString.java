package programming2020.leetcode.april_challenge;

import java.util.Stack;

public class BackSpaceString {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("y#fo##f",
                "y#f#o##f"));
    }

    public static boolean backspaceCompare(String S, String T) {

        String s1 = backspaceString(S);
        String s2 = backspaceString(T);
        System.out.println(s1);
        System.out.println(s2);
        return s1.equals(s2);

    }

    public static String backspaceString(String s){
        char arr[] = s.toCharArray();

        Stack<Character> stack = new Stack();
        for(int i = 0; i<s.length(); i++){
            if(!stack.isEmpty() && arr[i] == '#'){
                stack.pop();
            }
            else if(arr[i] == '#'){
                continue;
            }
            else
                stack.push(arr[i]);
        }
        StringBuilder sb = new StringBuilder();

        for(Character c :stack){
            sb.append(c);
        }

        return String.valueOf(sb);

    }

    public static String compress(String s){
        char arr[] = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i< arr.length; i++){
            if(i != arr.length-1 && arr[i+1] == '#' ){
                i+=2;
            }
            else
                sb.append(arr[i]);
        }
        return String.valueOf(sb);
    }
}

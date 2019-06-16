package programming2018.hackerRank.Stacks;

import java.util.Stack;

public class isBalancedBrackets {

    static String isBalanced(String s) {
        // Complete this function
        char arr[] = s.toCharArray();
        int l = 0;
        int r = arr.length-1;
        while(r>l){
            if(arr[l]==arr[r-1]) {
                l++;
                r--;
            }
            else
                return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        String result = isBalanced2("{[()]}");
        System.out.println(result);


    }

    static String isBalanced2(String s) {
        // Complete this function
        char arr[] = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(char c : arr){
            stack.push(c);
        }

        for (int i = 0; i < arr.length/2; i++) {

            char c = arr[i];
            char popped = stack.pop();
            if((c=='{'&& popped=='}')||(c=='['&& popped==']')||(c=='('&& popped==')'))
                continue;
            else
                return "NO";

        }

        return stack.isEmpty() ? "YES" : "NO";

    }

//Solution
/*    static programming2018.String isBalanced(programming2018.String s) {
        // Complete this function
        char arr[] = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
            //corner case when there are extra elements in the second half of the string
                if (stack.isEmpty()) {
                    return "NO";
                }

                char top = stack.pop();
                if (!((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{'))) {
                    return "NO";
                }
            }
        }

//corner case when there are extra elements in the first half of the string
        return stack.isEmpty() ? "YES" : "NO";
    }*/

}

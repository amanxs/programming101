package programming2020;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidParenthesisString {
    public static void main(String[] args) {
        ValidParenthesisString solution = new ValidParenthesisString();
        boolean ans = solution.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*");//"(())((())()()(*)(*()(())())())()()((()())((()))(*"
        System.out.println(ans);//"((*)(*))((*"
        //"((*)(*))((*" //**((*

    }

    public boolean checkValidStringSol(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '*')
                stack.push(ch);
            else if (ch == ')') {
                if ( ! stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    stack.push(ch);
            }
        }

        Deque<Pair<Integer, Character>> stars = new ArrayDeque<>();
        Deque<Pair<Integer, Character>> parenthesis = new ArrayDeque<>();
        for (int i = 0; ! stack.isEmpty() ; ++i) {
            char ch = stack.removeLast();
            if (ch == '*')
                stars.push(new Pair<>(i, ch));
            else if (ch == '(')
                parenthesis.push(new Pair<>(i, ch));
            else { // ch == ')'
                if ( ! parenthesis.isEmpty() )
                    parenthesis.pop();
                else if ( ! stars.isEmpty() )
                    stars.pop();
                else
                    return false;
            }
        }

        while ( ! parenthesis.isEmpty() ) {
            Pair<Integer, Character> pair = parenthesis.pop();
            if (stars.isEmpty())
                return false;
            if (stars.peek().getKey() < pair.getKey())
                return false;
            stars.pop();
        }

        return true;
    }

        Stack<Character> stack = new Stack<Character> ();
        public boolean checkValidString(String s) {
            char arr[] = s.toCharArray();
            if( arr.length <1  || (arr.length == 1 && arr[0] == '*')){
                return true;
            }
            stack.push(arr[0]);
            return checkValidStringOptimized(arr, arr.length);
        }

    public boolean checkValidString(char arr[], int n, int p) {
        int count =0;
        for(int i=1; i< n; i++){
            if(arr[i] == '*'){
                count++;
                continue;
            }
            if(!stack.isEmpty() && stack.peek() == '(' && arr[i] == ')'){
                stack.pop();
            }
            else{
                stack.push(arr[i]);
            }
        }
        System.out.println(stack.size());
        System.out.println(count);

        if(stack.isEmpty() || stack.size()<=count){
            return true;
        }
        return false;
    }

        public boolean checkValidString(char arr[], int i) {
            if(stack.isEmpty()){
                return true;
            }
            else if(!stack.isEmpty() && i > arr.length-1){
                return false;
            }
            if(arr[i] == '*'){
                char arrL[] = swap(arr, i, '(');
                boolean l = checkValidString(arrL, i);
                char arrR[] = swap(arr, i, ')');
                boolean r = checkValidString(arrR,i);

                return checkValidString(arr, i+1) || l || r;

            }
            if(stack.peek() == '(' && arr[i] == ')'){
                stack.pop();
            }
            else{
                stack.push(arr[i]);
            }
            return checkValidString(arr, i+1);
        }

        public char[] swap(char arr[], int i, char c){
            arr[i] = c;
            return arr;
        }

    public boolean checkValidStringOptimized(char arr[], int n) {
        int count =0;
        for(int i=1; i< n; i++){
            if(arr[i] == '*' || arr[i] == '('){
                stack.push(arr[i]);
            }
            else if(arr[i] == ')'){
                if(!stack.isEmpty() && stack.peek() == '(' ){
                    stack.pop();
                }
                else{
                    stack.push(arr[i]);
                }
            }

        }

        Stack<Character> parens = new Stack<Character> ();
        Stack<Character> stars = new Stack<Character> ();
        int i =0;

        for(char c : stack){
            i++;
            stars.add(i, null);
            parens.add(i, null);


            if(c == '*'){
                stars.add(i, c);
            }
            else if(c == '('){
                parens.add(i, c);
            }

            else{
                if(!parens.isEmpty()){
                    parens.pop();
                }

                else if(!stars.isEmpty()){
                    stars.pop();
                }

                else return false;
            }
        }
        ////**((*
        for(char c : parens){
            int j = parens.lastIndexOf(c);
            System.out.println(j);
            if(stars.isEmpty()){
                return false;
            }
            char s = stars.peek();
            System.out.println(stars.lastIndexOf(s));
            if(stars.lastIndexOf(s) <= j ){
                return false;
            }
            stars.pop();
        }
        return true;
    }

}

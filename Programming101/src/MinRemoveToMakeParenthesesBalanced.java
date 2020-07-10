import java.util.Stack;

public class MinRemoveToMakeParenthesesBalanced {

    public String minRemoveToMakeValidOpt(String s) {
        Stack<Integer> stack = new Stack<>();
        int insertIdx=0;
        StringBuilder builder = new StringBuilder();
        for(char c : s.toCharArray()){
            if( c == '('){
                stack.push(insertIdx);
            }else if( c == ')'){
                if( stack.isEmpty() ){
                    continue;
                }
                stack.pop();
            }
            builder.append(c);
            insertIdx++;
        }
        // remove open brackets
        while(!stack.isEmpty()){
            int del = stack.pop();
            builder.delete(del, del+1);
        }
        return builder.toString();
    }

    public String minRemoveToMakeValid(String s) {
        StringBuffer sb = new StringBuffer();
        char arr[] = s.toCharArray();
        int open =0;
        int closed =0;

        for(char c : arr){
            if(c == ')' ){
                if(open>closed){
                    //System.out.println("This is open: "+ open + " and this is closed: " + closed);
                    sb.append(c);
                    closed++;
                }
            }

            else if(c == '('){
                open ++;
                sb.append(c);
            }
            else sb.append(c);
        }

        String mid = String.valueOf(sb);
        //return mid;

        StringBuffer res = new StringBuffer();
        Stack<Character> stack = new Stack<Character>();
        open = 0;
        closed = 0;

        for(int i=mid.length()-1; i>=0; i--){
            char c = mid.charAt(i);
            if(c == '(' ){
                if(open<closed){
                    stack.push(c);
                    open++;
                }

            }
            else if(c == ')'){
                closed ++;
                stack.push(c);
            }
            else stack.push(c);
        }
        int n = stack.size();
        for(int p=0 ; p<n; p++){
            res.append(stack.pop());
        }
        return String.valueOf(res);

    }
}

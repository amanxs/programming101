package Facebook;

import java.util.*;

public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s){
        Set<String> visited = new HashSet<>();
        Queue<String> q   = new LinkedList<>();
        List<String> res = new ArrayList();
        boolean found = false;

        q.offer(s);
        visited.add(s);
        while(!q.isEmpty()){
            //String str = q.poll();
            String str = q.peek(); q.remove();
            if(isValid(str)){
                found = true;
                res.add(str);
                System.out.println(str);
            }
            if(found) continue;

            for(int i=0; i<str.length();i++){
                if(!isParen(str.charAt(i))) continue;
                String sub = str.substring(0,i) + str.substring(i+1);
                if(!visited.contains(sub)){
                    q.add(sub);
                    visited.add(sub);
                }

            }
        }

        return res;
    }

    private boolean isValid(String s){
        int stack =0;

        for(int i= 0 ; i< s.length(); i++){
            if(s.charAt(i) == '(') stack++;
            else if(s.charAt(i) == ')') stack--;
            if(stack<0) return false;
        }

        return stack==0;

    }

    private boolean isParen(char c){
        return (c=='(' || c==')');
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses obj = new RemoveInvalidParentheses();
        String expression = "()())()";
        obj.removeInvalidParentheses(expression);
    }

     void removeInvalidParenthesis(String str)
    {
        if (str.isEmpty())
            return;

        // visit set to ignore already visited string
        HashSet<String> visit = new HashSet<String>();

        // queue to maintain BFS
        Queue<String> q = new LinkedList<>();
        String temp;
        boolean level = false;

        // pushing given string as
        // starting node into queue
        q.add(str);
        visit.add(str);
        while (!q.isEmpty())
        {
            str = q.peek(); q.remove();
            if (isValid(str))
            {
                System.out.println(str);

                // If answer is found, make level true
                // so that valid string of only that level
                // are processed.
                level = true;
            }
            if (level)
                continue;
            for (int i = 0; i < str.length(); i++)
            {
                if (!isParen(str.charAt(i)))
                    continue;

                // Removing parenthesis from str and
                // pushing into queue,if not visited already
                temp = str.substring(0, i) + str.substring(i + 1);
                if (!visit.contains(temp))
                {
                    q.add(temp);
                    visit.add(temp);
                }
            }
        }
    }


}

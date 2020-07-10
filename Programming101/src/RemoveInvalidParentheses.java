import java.util.*;

public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList();
        HashSet<String> set = new HashSet();
        set.add(s);
        Queue<String> q = new LinkedList();
        q.offer(s);
        boolean found = false;
        while (!q.isEmpty() && !found) {
            int size = q.size();
            while (size > 0) {
                size--;
                String curr = q.poll();
                if (valid(curr)) {
                    found = true;
                    res.add(curr);
                }
                else if (!found) {
                    for (int i=0;i<curr.length();i++) {
                        String str = curr.substring(0,i) + curr.substring(i+1);
                        if (set.contains(str)) continue;
                        set.add(str);
                        q.offer(str);
                    }
                }
            }
        }
        return res;
    }

    public boolean valid(String s) {
        Stack<Character> stack = new Stack();
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                if (stack.isEmpty()) return false;
                else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}

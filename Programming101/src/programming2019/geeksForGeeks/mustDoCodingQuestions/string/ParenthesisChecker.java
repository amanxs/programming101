package programming2019.geeksForGeeks.mustDoCodingQuestions.string;

import programming2018.dataStructure.Stack;

/**
 * Given an expression string exp. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
 * For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”
 */
public class ParenthesisChecker {

    public static void main(String[] args) {
        String balanced = "[()]{}{[()()]()}";
        String notBalanced = "[(])";

        if(parenthesisChecker(balanced)){
            System.out.println("is Balanced");
        };

        if(!parenthesisChecker(notBalanced)){
            System.out.println("not Balanced");
        }
    }

    private static boolean parenthesisChecker(String parenthsis) {
        Stack <Character> stack = new Stack<>();
        for(char c : parenthsis.toCharArray()){
            if(c == '{' ||  c =='[' || c == '('){
                stack.push(c);
            }
            else if (c == '}' ||  c ==']' || c == ')') {
                if (!stack.isEmpty()) {
                    if (!isMatchingPair(stack.pop(), c)) {
                        return false;
                    }
                }
                else
                    return false;
            }
        }
        if (stack.isEmpty())
            return true;

        return false;
    }

    static boolean isMatchingPair(char character1, char character2)
    {
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else if (character1 == '[' && character2 == ']')
            return true;
        else
            return false;
    }

}

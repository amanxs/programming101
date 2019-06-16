package programming2018.hackerRank.Stacks;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Stack<Integer> stack = new Stack();
        Stack<Integer> maxStack = new Stack<Integer>();

        for (int i = 0; i < N ; i++) {
            int query = in.nextInt();
            switch (query){
                case 1:
                    int n = in.nextInt();
                    stack.push(n);
                    if (maxStack.isEmpty() || n>maxStack.peek())
                        maxStack.push(n);
                    break;

                case 2:
                    int popped = stack.pop();
                    if(maxStack.peek()==popped)
                        maxStack.pop();
                    break;

                case 3:
                    printMax(maxStack);
                    break;
                default:
                    break;
            }

        }
    }

    public static void printMax(Stack stack){
        System.out.println(stack.peek());
    }
}

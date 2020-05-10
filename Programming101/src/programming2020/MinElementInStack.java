package programming2020;

import java.util.Stack;

/**
 * Question: Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull()
 * and an additional operation getMin() which should return minimum element from the SpecialStack.
 * All these operations of SpecialStack must be O(1).
 * To implement SpecialStack, you should only use standard Stack data structure and no other data structure like arrays, list, .. etc.
 */
public class MinElementInStack {

    static Stack<Integer> stack = new Stack<>();
    static Stack <Integer> minStack = new Stack<>();

    public static void main(String args[]){
        MinElementInStack stack = new MinElementInStack();
        stack.push(18);
        stack.push(19);
        stack.push(29);
        stack.push(15);
        stack.push(16);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());

    }

    /**
     * MinStack minStack = new MinStack();
     minStack.push(-2);
     minStack.push(0);
     minStack.push(-3);
     minStack.getMin();   --> Returns -3.
     minStack.pop();
     minStack.top();      --> Returns 0.
     minStack.getMin();   --> Returns -2.
     */

    public static void push(int e){
        stack.push(e);
        if(minStack.isEmpty() || e <= minStack.peek()){
            minStack.push(e);
        }
    }

    public static void pop(){
        if(!minStack.isEmpty() && minStack.peek().equals(stack.peek())){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public Integer getMin() {
        return !minStack.isEmpty() ? minStack.peek() : null;
    }

}

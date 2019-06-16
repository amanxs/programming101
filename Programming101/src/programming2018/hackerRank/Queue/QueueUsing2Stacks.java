package programming2018.hackerRank.Queue;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsing2Stacks {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        MyQueue<Integer> queue = new MyQueue<Integer>();


        int queries = in.nextInt();
        for(int i = 0 ; i <queries;i++){
            int a = in.nextInt();

            switch(a){
            case 1 :
                queue.enqueue(in.nextInt());
                break;
            case 2 :
                int e = queue.dequeue();
                break;

            case 3 :
                System.out.println(queue.peek());

            }

        }
    }

    public static class MyQueue<T>{
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack <Integer> stack2 = new Stack<Integer>();

        public void enqueue(int i) {
            stack1.push(i);
        }

        public Integer dequeue( ) {

            if(size()==0)
                return null;

            stackShifting();

            return stack2.pop();
        }

        public Integer peek() {
            if(size()==0)
                return null;

            stackShifting();

            return stack2.peek();
        }

        private void stackShifting(){

            if(stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
        }

        public Integer size() {
            return stack1.size() + stack2.size();
        }
    }


}

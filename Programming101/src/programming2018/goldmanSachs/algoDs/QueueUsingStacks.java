package programming2018.goldmanSachs.algoDs;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingStacks {

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for(int i=0; i<T; i++){
            QueueStack<Integer> queue = new QueueStack<Integer>();

            int Q = in.nextInt();
            for(int j=0; j<Q;j++){
                switch (Q){
                    case 1:
                        queue.enqueue(in.nextInt());
                        break;
                    case 2:
                        int dequeued = queue.dequeue();
                        System.out.print(dequeued + " ");
                        break;

                }
            }
        }
    }

    static  class QueueStack<T>{

        Stack<Integer> stack1 = new Stack<Integer>();
        Stack <Integer> stack2 = new Stack<Integer>();

        public void enqueue(int n){
            stack1.push(n);

        }

        public Integer dequeue(){
            if(stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            return stack2.pop();
        }


    }


}

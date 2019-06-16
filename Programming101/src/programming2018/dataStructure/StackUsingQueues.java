package programming2018.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    // It can be done both ways by either making the push operation costly or pop operation costly
    /*
    This is implemented using the push operation costly
     */

     static Queue<Integer> queue1 = new LinkedList<>();
     static Queue<Integer> queue2 = new LinkedList<>();

    // To maintain current number of
    // elements
   static int curr_size;

    public StackUsingQueues()
    {
        curr_size = 0;
    }

    static void push(int x){
        curr_size++;
        queue2.add(x);

        while(!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }

        //swap the names of the two queues
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    static int pop(){
        // if no elements are there in q1
        if (queue1.isEmpty())
            return -1;

        int result = queue1.poll();
        curr_size--;
        return result;
    }

    int top()
    {
        if (queue1.isEmpty())
            return -1;
        return queue1.peek();
    }

    int size()
    {
        return curr_size;
    }


    //Driver function

    public static void main(String args[]){
        StackUsingQueues s = new StackUsingQueues();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.print(s.pop());

    }
}

package programming2018.Arrays;

public class SingleArrayToImplement2Stacks {

    static final int CAPACITY = 5;

    // Driver program to test twoStack class
    public static void main(String args[])
    {
        SingleArrayToImplement2Stacks ts = new SingleArrayToImplement2Stacks();
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from" +
                " stack1 is " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from" +
                " stack2 is " + ts.pop2());
    }


    int arr[] = new int[CAPACITY];

    int stack1Size= 0;
    int stack2Size = 0;


        // This will use the array from 0...x
        void push1(int a){
            arr[stack1Size++] = a;
        }

        int pop1(){
            return arr[--stack1Size];
        }

        // this will use the array from capacity...y
        void push2(int a){
            arr[CAPACITY- ++stack2Size] = a;
        }

        int pop2(){
            return arr[CAPACITY - stack2Size--];
        }



}

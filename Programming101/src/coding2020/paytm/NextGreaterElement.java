package coding2020.paytm;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args)
    {
        int arr[] = { 4 ,5 ,2, 25};
        int n = arr.length;
        printNGE(arr, n);
    }

    public static void printNGE(int arr[], int n){
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i< n; i++){
            while(!stack.isEmpty()  && arr[i]> stack.peek() ){
                int e = stack.pop();
                System.out.println("NGE of :  " + e + " is : " + arr[i]);
            }
            stack.push(arr[i]);
        }

        for(int e : stack){
            System.out.println("NGE of :  " + e + " is : " + -1);

        }
    }
}

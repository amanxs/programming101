package programming2018.paypal;

import java.util.Arrays;
import java.util.Stack;

public class replaceElementWithNearestBiggerNumberOnRightSide {

    public static void main(String args[]){

        int arr[] = {7, 5, 6, 3, 4, 1, 2, 9, 11};

        replaceGoingBackwards(arr, arr.length);
    }

    static void replace(int arr[], int n){

        int next, element;
        Stack<Integer> stack = new Stack<Integer>();

        int result[] = new int[n];
        Arrays.fill(result, -1);

        stack.push(arr[0]);

        for (int i = 1; i <arr.length ; i++) {

            next = arr[i];

            if(!stack.isEmpty()){
                element=stack.pop();
                int j= 1;

                while(element<next){

                    if(result[i-j]==-1) {
                        result[i - j] = next;

                        if(stack.isEmpty())
                            break;

                        element = stack.pop();
                    }

                    j++;

                }
                if(element>next)
                    stack.push(element);
            }
            stack.push(next);
        }

        for (int i = 0; i < n ; i++) {
            System.out.print(result[i]+ " ");
        }
    }

    static void replaceGoingBackwards(int arr[], int n){// int arr[] = {7, 5, 6, 3, 4, 1, 2, 9, 11};
        int result[] = new int[arr.length]; //result[] = 9 6 9 4 9 2 9 11 -1
        Arrays.fill(result,-1);
        Stack<Integer> stack = new Stack<>();//11 9 2 1         11 9 4 3

        stack.push(arr[n-1]);
        result[n-1] = arr[n-1]; // depending on the requirement

        for(int i= n-2; i>=0; i--){
            int element = arr[i];
            int next = 0;

            while(!stack.isEmpty()){
                 next = stack.pop();
                if(element < next){
                    result[i] = next;
                    break;
                }
            }

            stack.push(next);
            stack.push(element);

        }
        for (int i = 0; i < n ; i++) {
            System.out.print(result[i]+ " ");
        }
    }
}

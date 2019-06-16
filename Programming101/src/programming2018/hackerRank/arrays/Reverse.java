package programming2018.hackerRank.arrays;
import java.util.*;

/**
 * Given an array, , of  integers, print each element in reverse order as a single line of space-separated integers.
 */
public class Reverse {



    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int length = Integer.parseInt(s);
        String inputString = scan.nextLine();

        inputString = inputString.replaceAll("\\s","");

        char[] charArr = inputString.toCharArray();
        int[] intArray = new int[length];
        for (int i = 0; i < length ; i++) {
            intArray[i] = Integer.parseInt(String.valueOf(charArr[i]));
            System.out.println(intArray[i]);
            System.out.println(charArr[i]);

        }

        reverse(intArray,length);

    }

    private static void reverse(int[] intArray, int length) {

        int left = 0;
        int right = length-1;

        while(right>left) {
            swap(intArray, left, right);
            left++;
            right--;
        }

        for (int c: intArray){
            //System.out.print(Integer.valueOf(c)+ " ");

        }

    }

    private static void swap(int[] intArray, int left, int right) {
        int temp = intArray[right];
        intArray[right] = intArray[left];
        intArray[left] = temp;
    }

    //Solution
/*    public static void main(programming2018.String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = new int[scan.nextInt()];
        for(int i = 0; i < array.length; i++){
            array[i] = scan.nextInt();
        }
        scan.close();

        for(int i = array.length - 1; i >= 0; i--){
            System.out.print(array[i] + " ");
        }
    }*/

}

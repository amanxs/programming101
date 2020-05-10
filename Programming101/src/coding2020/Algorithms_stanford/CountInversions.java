package coding2020.Algorithms_stanford;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Inversion Count for an array indicates – how far (or close) the array is from being sorted.
 * If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
 * Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
 */
public class CountInversions {
    private static Reader in;
    private static PrintWriter out;

    private static final String INPUT_FILE_NAME = "intergerArray.txt";
    static int arr[] = new int[] { 1, 20, 6, 4, 5 };

    public static void main(String[] args) throws FileNotFoundException {
        String packageName = new CountInversions().getClass().getPackage().toString().split(" ")[1] + "/";

        //in = new Reader("/Users/amanarora/Downloads/Algorithms_stanford_input"+INPUT_FILE_NAME);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        System.out.println(packageName);
        int count = getInversionCount(arr) ;
        System.out.println(count);
    }

    private static int getInversionCount(int arr []){
        int count =0;
        for(int i =0; i< arr.length-1; i ++ ){
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]<arr[j]) {
                    count ++;
                }
            }
        }
        return count;
    }

    private static int getInversionCountOptimized(int arr[]){
        int count=0;
        return count;
    }
}

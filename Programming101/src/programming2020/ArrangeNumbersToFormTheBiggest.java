package programming2020;

import java.util.Arrays;
import java.util.Comparator;

public class ArrangeNumbersToFormTheBiggest {

    /**
     * Given an array of non-negative numbers(of Integer Range), they are needed to be arranged in some order
     * such that it gives the max number. For example given array is A[1, 34, 3, 98, 9, 76, 45, 4, 12, 121].
     * if we arrange these numbers in the following order, A[9, 98, 76, 45, 4, 34, 3, 12, 121, 1],
     * then by joining them we get “99876454343121211” as largest number.
     * @param args
     */
    public static void main(String[] args) {
       Integer arr[] = {9,98,76,45,4,34,3,12,121,1};
       String number = arrange(arr);
        System.out.println(number);
    }

    private static String arrange(Integer[] arr) {

        Arrays.sort(arr, new Comparator<Integer>(){

            @Override
            public int compare(Integer x, Integer y) {
                String X = x +""+ y;
                String Y = y +""+ x;
                Integer xy = Integer.valueOf(X);
                Integer yx =Integer.valueOf(Y);
                return yx.compareTo(xy);
            }
        });

        String number = "";
        for (Integer e : arr){
            number += e;
        }

        return number;
    }
}

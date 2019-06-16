package programming2018.goldmanSachs.algoDs;

import java.util.Arrays;
import java.util.Comparator;

public class ArrangeNumbersToFormLargest {

    public static void main(String args[]){

        Integer arr[] = {1, 34, 3, 98, 9, 76, 45, 4};
        arrange(arr);
    }

    static void arrange(Integer arr[]){

        //programming2018.Arrays.sort(arr, numberComparator);

        Arrays.sort(arr, new Comparator<Integer>(){

            @Override
            public int compare(Integer x, Integer y) {
                Integer xy = Integer.valueOf(x+""+y);
                Integer yx = Integer.valueOf(y+""+x);
                return yx.compareTo(xy);
            }
        });

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"");
        }
    }

}

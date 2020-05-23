package programming2020.leetcode.Contest;

import java.util.ArrayList;

public class TestRef{


    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2 = arr;
        arr2.add(2);
        get(arr);
        System.out.println(arr);
        System.out.println(arr2);
    }

    public static void get(ArrayList<Integer> arr){
        arr = null;
    }
}

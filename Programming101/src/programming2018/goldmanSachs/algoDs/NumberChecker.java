package programming2018.goldmanSachs.algoDs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberChecker {

    public static void main(int arr[]){
        ArrayList<Integer> list = new ArrayList<Integer>();

        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s= s+arr[i];
            if(s.contains("1") && s.contains("2") && s.contains("3"))
                list.add(Integer.parseInt(s));
        }
        if(list.isEmpty())
            System.out.println("-1");
        else{
            Collections.sort(list);
            System.out.println(list);
        }
    }

    public static void main2(int arr[]){
        ArrayList<Integer> list = new ArrayList<Integer>();

        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s= s+arr[i];
            if(s.contains("1") && s.contains("2") && s.contains("3"))
                list.add(Integer.parseInt(s));
        }
        if(list.isEmpty())
            System.out.println("-1");
        else{
            Collections.sort(list);
            System.out.println(list);
        }
    }

    private static boolean match(String s) {
        Pattern p = Pattern.compile(".*[123].*");
        s.contains("1");
        Matcher m = p.matcher(s);
        return (m.find());
    }
}

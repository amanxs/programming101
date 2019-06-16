package programming2018.coreJava;

import java.util.List;

public class WildCardGeneric {
    private static void add(List<? extends Number> list){
        //list.add(4);
        //list.add(8);
        System.out.println(list.get(0));
    }
}

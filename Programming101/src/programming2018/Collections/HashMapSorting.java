package programming2018.Collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.*;
import java.util.*;

public class HashMapSorting {

    public static void main(String args[]) {
        // let's create a map with Java releases and their code names
        HashMap<String, String> unsortedMap = new HashMap<String, String>();
        unsortedMap.put("JDK 1.1.4", "Sparkler");
        unsortedMap.put("J2SE 1.2", "Playground");
        unsortedMap.put("J2SE 1.3", "Kestrel");
        unsortedMap.put("J2SE 1.4", "Merlin");
        unsortedMap.put("J2SE 5.0", "Tiger");
        unsortedMap.put("Java SE 6", "Mustang");
        unsortedMap.put("Java SE 7", "Dolphin");
        System.out.println("HashMap before sorting, random order ");

        Set<Entry<String, String>> entries = unsortedMap.entrySet();

        for (Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " ==> " + entry.getValue());
        }
       /* Now let's sort the HashMap by values
         There is no direct way to sort HashMap by values but you can do this by writing your own comparator, which takes
         Map.Entry object and arrange them in order increasing or decreasing by values.*/


        Comparator<Entry<String, String>> valueComparator = new Comparator<Entry<String, String>>() {

            @Override
            public int compare(Entry<String, String> e1, Entry<String, String> e2) {
                String v1 = e1.getValue();
                String v2 = e2.getValue();
                return v1.compareTo(v2);
            }
        };

        // Sort method needs a List, so let's first convert Set to List in Java
        List<Entry<String, String>> listOfEntries = new ArrayList<Entry<String, String>>(entries);


        // sorting HashMap by values using comparator
        Collections.sort(listOfEntries, valueComparator);

        //Java 8 to gey sortedList

        /*Map<Integer, programming2018.String> sortedMap =
                unsortedMap.entrySet().stream()
                        .sorted(Entry.comparingByValue())
                        .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));*/


        LinkedHashMap<String, String> sortedByValue = new LinkedHashMap<String, String>(listOfEntries.size());

        // copying entries from List to Map
        for(Entry<String, String> entry : listOfEntries){
            sortedByValue.put(entry.getKey(), entry.getValue());
        }

        System.out.println("HashMap after sorting entries by values ");

        Set<Entry<String, String>> entrySetSortedByValue = sortedByValue.entrySet();

        for(Entry<String, String> mapping : entrySetSortedByValue){
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
        }


    }

}
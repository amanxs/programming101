package programming2020.leetcode.may_challenge;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.*;

import java.util.stream.Collectors;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        SortCharactersByFrequency obj = new SortCharactersByFrequency();
        System.out.println(obj.frequencySort("tree"));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char arr[] = s.toCharArray();

        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }
            else {
                map.put(arr[i], 1);
            }
        }
//        map.entrySet().stream()
//                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
//                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));

        Map<Character, Integer> sortedMap =
                map.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        StringBuilder sb = new StringBuilder();
        for(Entry<Character, Integer> entry : sortedMap.entrySet()){
            for(int i=0; i< entry.getValue(); i++){
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}

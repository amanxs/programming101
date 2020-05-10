package programming2020;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String args[]){
        char first = getFirstNonRepeatingChar("geeksforgeeks");
        System.out.print(first);

    }

    private static char getFirstNonRepeatingChar(String str) {
        char arr[] = str.toCharArray();
        List<String> lost = new ArrayList<>();
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for(int i =0; i< arr.length; i++ ){
            if(countMap.containsKey(arr[i])){
                countMap.put(arr[i], countMap.get(arr[i])+1);
            }
            else
                countMap.put(arr[i],1);

        }
        char nonRepeatingChar = 0;

        for (Character key : countMap.keySet()){
            if(countMap.get(key)==1)
                return key;
        }

//        countMap.keySet().stream().findFirst(key -> (countMap.get(key)==1));
//        countMap.entrySet().stream().forEach(entry -> {
//            if(entry.getValue()==1){
//                nonRepeatingChar = entry.getKey();
//            }
//        });

        return nonRepeatingChar;
    }
}

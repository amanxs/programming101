package programming2018.top10GeeksForGeeks.arrays;

import java.util.*;

/**
 * Given an array of distinct elements, rearrange the elements of array in zig-zag fashion in O(n) time.
 * The converted array should be in form a < b > c < d > e < f.
 */
public class ConvertArrayIntoZigZagFashion {

    public static void main(String args[]){
        int result = getMaxOccurrencess("abcde", 2, 4, 26);
        System.out.print(result);
    }

    static int getMaxOccurrences(String s, int minLength, int maxLength, int maxUnique) {

        int count =0;
        for(int i=0; i<s.length(); i++)
            for(int j=i+1; j<= s.length(); j++){
                String substring = s.substring(i,j);
                if(hasMinLength(substring,minLength) && hasMaxLength(substring, maxLength) && hasMaxUnique(substring, maxUnique))
                    count++;
            }

        return count;

    }


    static boolean hasMinLength(String s, int minLength){
        return s.length() >= minLength;
    }

    static boolean hasMaxLength(String s, int maxLength){
        return s.length() <= maxLength;
    }

    static boolean hasMaxUnique(String s, int maxUnique){
        return s.length() - duplicates(s) <= maxUnique;
    }

    static int duplicates(String s){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char arr[] = s.toCharArray();

        for(Character c : arr)
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);


        int duplicates = 0;

        for(Character c : map.keySet()){
            if(map.get(c)>1)
                duplicates++;
        }

        return duplicates;
    }




    static int getMaxOccurrencess(String string, int K, int L, int M) {

        int length = string.length();

        Map<String, Integer> substrCount = new HashMap<String, Integer>();

        for (int c = 0 ; c < length ; c++) {
            for (int i = 2 ; i <= length - c ; i++) {
                String sub = string.substring(c, c+i);
                if (sub.length() < K || sub.length() > L) {
                    continue;
                }
                int distinct = countDistinct(sub);
                if (distinct < 2 || distinct > M) {
                    continue;
                }
                if (substrCount.containsKey(sub)) {
                    substrCount.put(sub, substrCount.get(sub) + 1);
                } else {
                    substrCount.put(sub, 1);
                }
            }
        }

        Set<String> count = rank(substrCount);
        return (Integer.valueOf(count.iterator().next().substring(0, 6)));


    }

    private static int countDistinct(String sub) {
        int distinct = 0;
        Set<Character> chars = new HashSet<Character>();
        for (Character character : sub.toLowerCase().toCharArray()) {
            if (chars.add(character)) {
                distinct++;
            }
        }
        return distinct;
    }

    private static Set<String> rank(Map<String, Integer> substrCount) {
        Set<String> count = new TreeSet<String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        for (Map.Entry<String, Integer> entry : substrCount.entrySet()) {
            int zeroes = 6 - String.valueOf(entry.getValue()).length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < zeroes; i++) {
                sb.append("0");
            }
            sb.append(entry.getValue());
            count.add(sb.toString() + entry.getKey());
        }
        return count;
    }
}

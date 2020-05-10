package programming2020.leetcode.april_challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class GroupAnagrams {

    int prime[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    public static void main(String args[]) {
        String input[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams test = new GroupAnagrams();
        List<List<String>> result = test.groupAnagrams(input);
        System.out.println(result);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Integer, List<String>> countMap = new HashMap<Integer, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            int hash = getHashForString(strs[i]);
            updateMap(hash, countMap, strs[i]);

        }
        for(List<String> anagrams : countMap.values()){
            result.add(anagrams);
        }
        return result;
    }

    private void updateMap(int hash, Map<Integer, List<String>> countMap, String s) {
        if (countMap.containsKey(hash)) {
            List<String> list = countMap.get(hash);
            list.add(s);
            countMap.put(hash, list);
        }
        else{
            List<String> list = new ArrayList<>();
            list.add(s);
            countMap.put(hash, list);
        }
    }

    private int getHashForString(String str) {
        char arr[] = str.toCharArray();
        int hash =1;

        for(int i=0; i<arr.length; i++){
            int c = arr[i] - 'a';
            int p = getPrime(c);
            hash *= p;
        }

        return hash;
    }

    private int getPrime(int c) {
        return prime[c];
    }
}

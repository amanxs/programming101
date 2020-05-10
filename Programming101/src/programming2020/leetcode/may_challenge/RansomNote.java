package programming2020.leetcode.may_challenge;

import java.util.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        boolean ans = canConstruct("aa",
        "ab");
        System.out.println(ans);
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
        char mag[] = magazine.toCharArray();
        for(int i=0; i<mag.length; i++){
            if(countMap.containsKey(mag[i])){
                countMap.put(mag[i], countMap.get(mag[i]) +1);
            }
            else{
                countMap.put(mag[i], 1);//a1 b1
            }
        }
        char ransom[] = ransomNote.toCharArray();
        for(int i=0; i<ransom.length; i++){
            if(countMap.containsKey(ransom[i]) && countMap.get(ransom[i]) > 0){
                countMap.put(ransom[i], countMap.get(ransom[i]) -1);

            }
            else
                return false;
        }
        return true;
    }
}

package programming2018.goldmanSachs.algoDs;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstNonRepeatingCharacter {

    public static void main(String args[]){
        char first = getFirstNonRepeatingCharUsingLinkedHashMap("geeksforgeeks");
        System.out.print(first);

    }

    static char getFirstNonRepeatingChar(String s){

        HashMap<Character, Integer> hm = new HashMap<>();
        //LinkedHashMap<> lm = new LinkedHashMap();

        for(int i = 0; i<s.length(); i++){
            if(hm.containsKey(s.charAt(i)))
                hm.put(s.charAt(i),hm.get(s.charAt(i))+1);

            else
                hm.put(s.charAt(i),1);

        }


        for (int i = 0; i <s.length() ; i++) {
            if(hm.get(s.charAt(i))==1)
                return s.charAt(i);
        }

        return 0;

    }

    static char getFirstNonRepeatingCharUsingLinkedHashMap(String s){

        LinkedHashMap<Character, Integer> hm = new LinkedHashMap();

        for(int i = 0; i<s.length(); i++){
            if(hm.containsKey(s.charAt(i)))
                hm.put(s.charAt(i),hm.get(s.charAt(i))+1);

            else
                hm.put(s.charAt(i),1);

        }

        for (Character c : hm.keySet()){
            if(hm.get(c)==1)
                return c;
        }


        return 0;

    }

}

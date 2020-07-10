import java.util.HashMap;
import java.util.Map;

public class VerifyIfAlienIsSorted {

    Map<Character, Integer> dict;
    public boolean isAlienSorted(String[] words, String order) {
        dict = new HashMap<>();//0(order)
        for(int i=0; i<order.length(); i++){
            dict.put(order.charAt(i), i);
        }

        for(int i=0; i<words.length-1; i++){//O(words*k)
            if(compare(words[i], words[i+1])>0) return false;
        }

        return true;
    }

    public int compare(String w1, String w2){
        int n = Math.min(w1.length(), w2.length());
        for(int i =0; i<n ; i++){
            int c1 = w1.charAt(i);
            int c2 = w2.charAt(i);
            if(c1!=c2){
                return (dict.get(c1) - dict.get(c2));
            }
        }

        return 0;
    }
}

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public static void main(String[] args) {
        String s = minWindow("ADOBECODEBANC",
                "ABC");
    }


        public static String minWindow(String s, String t) {
            int len = t.length();
            Map<Character, Integer> map = new HashMap<>();
            for(int i=0; i<len; i++){
                char c =t.charAt(i);
                map.put(t.charAt(i), map.getOrDefault(c,0) +1);
            }
            int start =0, end =0;
            int missing =len;
            int window = s.length();
            String res = s;
            while(end<s.length()){
                char c = s.charAt(end);
                System.out.println( map.get('A'));
                System.out.println( map.get('C'));

                if(map.containsKey(c)){

                     if(map.get(c)>0) missing--;

                    map.put(c, map.get(c)-1);
                }

                while(missing ==0 && end>=start){
                    //System.out.println(s.charAt(end));
                    //System.out.println(end);
                    if(end-start +1 <window){
                        window = end - start +1;
                        res = s.substring(start, end+1);
                    }

                    if(map.containsKey(s.charAt(start)) ){

                        if(map.get(s.charAt(start))==0)missing++;

                        map.put(s.charAt(start), map.get(s.charAt(start))+1);
                    }
                    start++;
                    //System.out.println(missing);

                }
                end++;
            }

            return res;
        }


}

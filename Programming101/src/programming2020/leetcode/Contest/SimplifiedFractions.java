package programming2020.leetcode.Contest;

import java.util.ArrayList;
import java.util.List;

public class SimplifiedFractions {
    public static void main(String[] args) {
        System.out.println(simplifiedFractions(4));

    }
    public static List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        if(n==1) return list;
        for(int i=2; i<=n; i++){
            String s1 = "1/"+i;
            list.add(s1);
            for(int j =2 ; j<i; j++){
                if(i%j == 0 || gcd(i,j)!=1) continue;
                String s2 = j+"/"+i;
                list.add(s2);
            }

        }
        return list;
    }

    public static int gcd(int x, int y){
        if(y == 0){
            return x;
        }
        return gcd(y, x%y);
    }

}

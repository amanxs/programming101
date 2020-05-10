package programming2020.leetcode.may_challenge;

public class NumberComplement {

    public int findComplement(int n) {
        int number_of_bits =
                (int)(Math.floor(Math.log(n) /
                        Math.log(2))) + 1;

        // XOR the given integer with poe(2,
        // number_of_bits-1 and print the result
        return ((1 << number_of_bits) - 1) ^ n;

//         StringBuilder sb = new StringBuilder();
//         int count=0;
//         for(int i = 31; i>=0 ; i--){
//             int k = num >> i;
//             if((k & 1) > 0){
//                 sb.append("1");
//                 count++;

//             }
//             else if(count>0){
//                 sb.append("0");
//             }
//         }
//         String bits = String.valueOf(sb);
//         return complement(bits);
    }
    public int complement(String bits){
        int n = bits.length();
        String ones = "";
        for(int i=0; i< n; i++){
            ones += flip(bits.charAt(i));
        }
        return Integer.valueOf(bits);
    }

    public char flip(char c){
        return (c=='0') ? '1' : '0';
    }

}

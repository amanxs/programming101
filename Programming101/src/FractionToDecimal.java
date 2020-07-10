import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {// 1 2
        if (numerator == 0) return "0";
        boolean sign = (numerator < 0) ^ (denominator < 0);
        StringBuilder sb = new StringBuilder();
        if (sign) sb.append("-");


        /**
         -1
         -2147483648
         Output
         "0.0000000000000000000000000000001"
         Expected
         "0.0000000004656612873077392578125"
         */
        long num = Math.abs(new Long(numerator));//Fails for above input for int value. So converting to long
        long den = Math.abs(new Long(denominator));

        long rem = (num % den) * 10;

        sb.append(num / den);
        if (rem != 0) sb.append(".");

        Map<Long, Integer> map = new HashMap<>();
        while (rem != 0) {
            //After reading the code more carefully I see that the test "if (map.containsKey(num))" tests not just the occurrence of the last decimal but the occurrence of the whole numerator.
            // So, for example in the case of 123 / 999 it will put the parenthesis as soon as it finds 123 in the decimal part.
            if (map.containsKey(rem)) {
                sb.insert(map.get(rem), "(");
                sb.append(")");
                break;

            }
            map.put(rem, sb.length());
            sb.append(rem / den);
            rem = (rem % den) * 10;

        }


        return new String(sb);

    }

    /**
     * The code doesn't stop when it sees a digit repeated. It stops when it notes that it has reached a state which it was already in.
     * If it reaches the same state again, it means that we are about to repeat a division that we have already done, which means that the dividend and remainder are going to be the same,
     * and we are going to do the same series of steps we have already done.

     When that happens, it means a repetition, and it stops and adds the parentheses.

     For example, let's divide 123 by 999. This should give us the repeating decimal 0.123123123..., so the output should be 0.(123).

     123 / 999 is 0. The remainder is 123. We start with 0.
     Multiply the remainder by 10. Now we have 1230 / 999. Dividend is 1, remainder is 231. Now we have 0.1
     Multiply the remainder by 10. Now we have 2310 / 999. Dividend is 2, remainder is 312. Now we have 0.12
     Multiply the remainder by 10. Now we have 3120 / 999. Dividend is 3, remainder is 123. Now we have 0.123
     Multiply the remainder by 10. Now we have 1230 / 999... wait, we have already done that! That means that as we continue to divide, we'll get to that number again and again. Stop and put parentheses around the repeating part.
     The map is there to tell us which numbers we have already divided, and at which index in the StringBuilder. When we find a number we have already divided, we use that index to know where to insert the parenthesis.
     */


}

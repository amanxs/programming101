package coding2020.paytm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MinCost {
    private static List<String> substrings(String s) {
        int length = s.length();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                list.add(s.substring(i, j));
            }
        }
        return list;
    }

    private static int solve(String str, int charCost, int subStringCost) {
        int inputStringLength = str.length();
        int minCost = 0;
        int resultStringLength  = 0;

        StringBuilder sb = new StringBuilder(inputStringLength);
        HashSet<String> set  = new HashSet<>();


        sb.append(str.charAt(0));
        set.add(sb.toString());
        minCost += charCost;

        for (int i = 1; i < inputStringLength; i++) {
            resultStringLength = sb.length();

            while (resultStringLength > 0) {
                int temp = i + resultStringLength;
                int end = (temp > inputStringLength) ? inputStringLength : temp;
                String lookAhead = str.substring(i, end);
                if (set.contains(lookAhead)) {
                    if (lookAhead.length() == 1 && charCost <= subStringCost) {
                        minCost += charCost;
                    } else {
                        minCost += subStringCost;
                    }

                    i += resultStringLength - 1;
                    sb.append(lookAhead);
                    for (String sub : substrings(sb.toString())) {
                        set.add(sub);
                    }
                    break;
                }
                else {
                    if (lookAhead.length() == 1) {
                        minCost += charCost;
                        sb.append(lookAhead);
                        for (String sub : substrings(sb.toString())) {
                            set.add(sub);
                        }
                        break;
                    }
                    resultStringLength--;
                }
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        System.out.println(solve("cabcjpsdaedsasedsascabcjpsddsdaedsasedsa", 1, 3)); // 26
        //System.out.println(solve("bacbacacb", 8, 9)); // 42
    }
}

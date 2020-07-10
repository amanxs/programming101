import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidNumber {
   public static Pattern p = Pattern.compile("(\\+|-)?(([0-9]+(\\.([0-9]+)?)?)|((\\.[0-9]+)))(e(\\+|-)?[0-9]+)?");

    public boolean isNumberRegex(String s) {
        s = s.trim();
        Matcher m = p.matcher(s);
        return m.matches();
    }

    public static void main(String[] args) {

    }


    public boolean isNumber(String s) {
        s = s.trim();
        if(s.isEmpty()) return false;
        boolean isDotFound = false;
        boolean isExpFound = false;
        boolean isNumFound = false;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
            }
                if(Character.isDigit(c)) {
                isNumFound = true;
                continue;
            }
            if(c == '-' || c == '+') {
                if(i != 0 && s.charAt(i - 1) != 'e') return false;
                continue;
            }
            if(c == '.') {
                if(isDotFound || isExpFound) return false;
                isDotFound = true;
                continue;
            }
            if(c == 'e') {
                if(!isNumFound || isExpFound) return false;
                isNumFound = false;
                isExpFound = true;
                continue;
            }
            return false;
        }
        return isNumFound;
    }
}

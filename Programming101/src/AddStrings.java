package programming2020;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder sb=new StringBuilder();int carry=0;
        for(int n1=num1.length()-1,n2=num2.length()-1;n1>=0 || n2>=0 ;n1--,n2--){
            int x=n1>=0? num1.charAt(n1)-'0':0;
            int y=n2>=0 ?num2.charAt(n2)-'0':0;
            sb.insert(0,(x+y+carry)%10);
            carry= (x+y+carry)/10;

        }
        if(carry>0) sb.insert(0,carry);
        return sb.toString();
    }
}

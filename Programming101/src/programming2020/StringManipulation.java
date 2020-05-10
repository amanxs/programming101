package programming2020;

public class StringManipulation {
    /**
     * Replace all spaces in a programming2018.String with %20
     */
    public static final String constant= "%20";
    public static void main(String args[]){
        String s = "a bc d ef";
        System.out.println(s);

        manipulate(s, 9);
    }

    private static void manipulate(String str, int length) {
        char arr[] = str.toCharArray();
        StringBuilder builder = new StringBuilder();

        for(int i=0 ; i< length; i++){
          if(arr[i]==' '){
              builder.append(constant);
          }
          else{
              builder.append(arr[i]);
          }
        }

        System.out.println(builder.toString());
    }


}

package programming2019.geeksForGeeks.mustDoCodingQuestions.string;

public class StringPermutations {

    public static void main(String[] args) {
        String s = "abc";
        char arr [] = s.toCharArray();
        //getPermutations(s);
        permutations(s);
    }

    private static void permutations(String s){
        permutations(s, 0,s.length());
    }

    private static void permutations(String s, int l, int r){
        if(r<=l) {
            System.out.println(s);
        }

        else {
            for (int i = l; i < r; i++) {
                s = swap(s, l, i);
                permutations(s, l +1, r);
            }
        }
    }
    private static String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;

        return String.valueOf(arr);
    }

}

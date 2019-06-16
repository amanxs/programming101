package programming2018.top10GeeksForGeeks.arrays;

public class StringReverseWithoutAffectingSpecialChars {

    public static void main(String args[]){
        reverse("a!!!b.c.d,e'f,ghi");
    }

    static void reverse(String s) {
        char arr[] = s.toCharArray();
        int l = 0;
        int r = s.length();

        while (l < r) {
            if (!Character.isAlphabetic(arr[l]))
                l++;

            else if (!Character.isAlphabetic(arr[r]))
                r--;

            else {
                swap(arr, l, r);
            }

        }
    }
    static void swap(char arr[], int l, int r){
        char temp = arr[l];
        arr[l] =arr[r];
        arr[r] = temp;
    }
}

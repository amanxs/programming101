package programming2018.goldmanSachs.algoDs;

public class StringManipulation {

    //Given a string and a length; Output the string such that count of same adjacent characters in programming2018.String are less than the length
    public static void main(String args[]){
        manipulate("abbcdddcce",3);
        }

    static void manipulate(String s, int n){
        char arr[] = s.toCharArray();
        char curr=arr[0];
        int count = 1;
        String str = curr+"";
        for(int i=1 ; i<arr.length; i++){
            if(arr[i]==curr){
                count++;
            }
            else{
                curr=arr[i];
                count=1;
            }
            if(count<n)
                s=s+arr[i];
        }
    }

}

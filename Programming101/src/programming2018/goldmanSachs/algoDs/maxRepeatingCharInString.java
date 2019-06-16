package programming2018.goldmanSachs.algoDs;

public class maxRepeatingCharInString {

    static String maxRepeating(String s){
        char arr[] = s.toCharArray();
        char curr = arr[0];
        char max = curr;
        int count = 1;
        int maxCount = count;

        for(int i = 1; i<arr.length;  i++){
            if(arr[i]==curr){
                count++;
            }
            else{
                    curr = arr[i];
                    count = 1;
            }
            if(maxCount<count){
                maxCount =count;
                max= curr;
            }
        }

        return max+""+maxCount;

    }

    static String maxRepeatingLessThanN(String s,int n){
        char arr[] = s.toCharArray();
        char curr = arr[0];
        char max = curr;
        int count = 1;
        int maxCount = count;

        for(int i = 1; i<arr.length;  i++){
            if(arr[i]==curr){
                count++;
            }
            else{
                curr = arr[i];
                count = 1;
            }
            if(maxCount<count){
                maxCount =count;
                max= curr;
            }
        }

        return max+""+maxCount;

    }


    public static void main(String args[]){
        String c = maxRepeating("aannnsssssss");
        System.out.println(c);
    }
}

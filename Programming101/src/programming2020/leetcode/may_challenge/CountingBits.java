package programming2020.leetcode.may_challenge;

public class CountingBits {

    public static void main(String[] args) {
        System.out.println(countBits(5));
    }

    public static int[] countBits(int num){
        int[] result = new int[num+1];
        for(int i=0; i<=num ;i++){
            result[i] = countEach(i);
        }
        for(int r : result){
            System.out.println(r);
        }
        return result;

    }

    public static int countEach(int num){
        int res=0;
        while(num!=0){
            if(num%2 ==1){
                res++;
            }
            num = num/2;
        }

        return res;
    }

}

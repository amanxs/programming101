package programming2020;

/**
 * There are n houses build in a line, each of which contains some value in it.
 * A thief is going to steal the maximal value of these houses, but he can’t steal in two adjacent houses
 * because the owner of the stolen houses will tell his two neighbours left and right side.
 * What is the maximum stolen value?
 */
public class MaxStolenValue {

    public static void main(String args[]){
        int hVal[] = {6, 7, 1, 3, 8, 2, 4};
        int maxVal = getMaxStolenValue(hVal, hVal.length);
    }

    private static int getMaxStolenValue(int hVal[], int n){
        if(n==0)
            return 0;
        if(n==1 || n==2)
            return Math.max(hVal[0], hVal[1]);

        int DP[] = new int[n+1];

        DP[0] = hVal[0];
        DP[1] = Math.max(hVal[0], hVal[1]);

        for(int i=2; i< hVal.length; i++){
                DP[i] = Math.max(hVal[i] + hVal[i-2], hVal[i-1]);
        }

        return DP[n-1];
    }
}

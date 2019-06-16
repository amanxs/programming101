package programming2018.Algorithms;

/*
 * Compute the greatest common divisor of two nonnegative integers p and q as follows:
 *  If q is 0, the answer is p. If not, divide p by q and take the remainder r.
 *   The answer is the greatest common divisor of q and r.
 */
public class ComputeGcd {

    public static void main(String args[]){
        gcd(15,45);
    }

    static int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b%a,a);


    }

    //Time Complexity: O(Log min(a, b))


}

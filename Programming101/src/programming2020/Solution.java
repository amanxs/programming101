package programming2020;

/* Problem Name is &&& Election &&& PLEASE DO NOT REMOVE THIS LINE. */

import java.util.ArrayList;
import java.util.List;

/**
 * Instructions to candidate.
 * 1) Run this code in the REPL to observe its behaviour. The
 * execution entry point is main().
 * 2) Consider adding some additional tests in doTestsPass().
 * 3) Implement whoIsElected() correctly.
 * 4) If time permits, try to improve your implementation.
 */


public class Solution {

    /**
     * A group of students are sitting in a circle. The teacher is electing a new class president.
     * The teacher does this by singing a song while walking around the circle. After the song is
     * finished the student at which the teacher stopped is removed from the circle.
     *
     * Starting at the student next to the one that was just removed, the teacher resumes singing and walking around the circle.
     * After the teacher is done singing, the next student is removed. The teacher repeats this until only one student is left.
     *
     * A song of length k will result in the teacher walking past k students on each round. The students are numbered 1 to n.
     * The teacher starts at student 1.
     *
     * For example, suppose the song length is two (k=2). And there are four students to start with (1,2,3,4). The first
     * student to go would be `2`, after that `4`, and after that `3`. Student `1` would be the next president in this example.
     *
     * @param n the number of students sitting in a circle.
     * @param k the length (in students) of each song.
     * @return the number of the student that is elected.
     */
    public static int whoIsElected(int n, int k) {
        // todo: implement here
        System.out.println(n);
        int arr[] = new int[n];//4
        int l = arr.length;

        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }

        int i=-1;

        while(n>1){
            //int blocks_left = l-i;

            //i = i+k > l -1 ? k-blocks_left : i+k;

            for(int j=1; j<=k ; j++){
                int blocks_left = l-i;
                i = blocks_left > 1 ? i+1 : 0;

                if(arr[i]==0){
                    i++;
                }
            }

            System.out.println(arr[i]);

            arr[i] = 0;

            n--;
        }


        //Result
        for(int p=0; p< arr.length; p++){
            if(arr[p] != 0){
                return arr[p];
            }
        }
        return -1;
    }

    public static int electedCandidate(int n, int k) {
        if(n<=k){
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        for(int i =1; i<= n; i++){
            list.add(i);
        }

        int i=-1;
        while(n>1){
            //i = i+k < list.size() ? i+k :   ;
            n--;
        }
        if(n<k){

        }

        return 0;
    }

    /**
     * The recursive approach is as follows:

     Suppose 𝑓(𝑛,𝑘) is the solution the problem and he is the lucky guy that ultimately lives .

     lucky guy (starting from first iteration)= lucky guy (starting from second iteration)

     The lucky guy doesn’t change from iteration to iteration but his index from round to round changes.

     Let us change the indexing system from[1𝑡𝑜𝑛] to[0𝑡𝑜𝑛−1]for simplicity in programming and understanding.

     now in the first iteration (𝑘−1)𝑡ℎ person is killed, the remaining number of persons are 𝑛−1.

     Now for the second iteration of killing , let us look at the change in the indexing system (first iteration 𝑁persons alive, second iteration 𝑁−1persons alive)

     first iteration —->0,1,2,3,…,𝑘−1,𝑘,𝑘+1,…,𝑁−2,𝑁−1 (k-1 th person killed)

     for second iteration the indexing starts from 𝑘.

     kth person in first iteration will be 0th person in second iteration.

     𝑘+1th person first iteration will be in 1st position in second iteration.

     similarly, If𝑓(𝑛−1,𝑘) is the solution and index of lucky guy in second iteration then his index in first iteration would be ((𝑘+𝑓(𝑛−1,𝑘))

     (remainder is taken so as to limit the indices below N )

     (𝑎is remainder obtained when 𝑎is divided by 𝑏).

     Thus we obtain the recursive relation

     𝑓(𝑛,𝑘)=(𝑓(𝑛−1,𝑘)+𝑘)

     this gives the solution in 0 indexing system, to get answer in 1 indexing system add 1 to the solution.
     * @param n
     * @param k
     * @return
     */

        public static int getIndex(int n, int k){
            if (n == 1)
                return 0;

            return (getIndex(n-1, k) +k) % n  ;
        }

    int Josephus(int n,int k)
    {
        int result=0; //for n=1
        for(int i=2;i<=n;i++)
        {
            result=(k+result)%i;
        }
        return (result+1);  //adding 1 to change indexing;
    }

        /**
         * bool doTestsPass()
         * Runs various tests. Returns true if tests pass. Otherwise,
         * returns false.
         */
    public static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        // test cases are structered as {n, k, expected answer}
        int[][] testCases = {
                {1, 1, 1},
                {2, 2, 1},
                {4, 2, 1},
                {100, 2, 73},
        };

        for (int[] testCase : testCases) {
            int answer = getIndex(testCase[0], testCase[1]);
            if (answer != testCase[2]) {
                System.out.println("test failed!");
                System.out.printf("n:%d, k%d, answer got: %d, should be: %d\n", testCase[0], testCase[1], answer, testCase[2]);
                return false;
            }
        }
        System.out.println("All tested passed");
        return true;
    }

    /**
     * Execution entry point.
     */
    public static void main(String args[]) {
        //doTestsPass();
        int answer = getIndex(100, 2) +1;
        System.out.println(answer);

    }
}

package programming2020.leetcode.june_challenge;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * <p>
 * Note:
 * The number of people is less than 1,100.
 * <p>
 * <p>
 * Example
 * <p>
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstruction {

    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Arrays.sort(people, (a, b) -> compareTo(a, b));
        //[[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(people[i][1], people[i]);
        }
        //The output array will look like 5,0 7,0 6,1 7,1 and then when we insert 5,2 this says there should be 2 elements
        // ahead of if so at index 2  we will insert this to array and then the output array will look like this 5,0 7,0 5,2 6,1 7,1
        // One this to note is that all the shifting happens in a way that objects with height greater than the current elements are shifter
        // to positions after i and their property for k(elements greater than them is maintained because the element that is added
        // is smaller these elements. So at index i we have an element that has i elements greater than it. And then when an element with the
        // same index is added later that will have a smaller height because the way elements were sorted and thus can be added infront
        // on this indext moving the element that is already there on the index.
        //
        int res[][] = new int[n][2];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
            //System.out.print(list.get(i)[0]);
            //System.out.println(list.get(i)[1]);

        }
        return res;
    }

    public int compareTo(int[] a, int[] b) {
        return a[0] != b[0] ? b[0] - a[0] : a[1] - b[1];

    }
}

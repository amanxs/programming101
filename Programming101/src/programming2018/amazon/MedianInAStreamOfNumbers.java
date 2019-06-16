package programming2018.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianInAStreamOfNumbers {

    /**
     * When the input size is odd, we take the middle element of sorted data.
     * If the input size is even, we pick average of middle two elements in sorted stream.
     */

    public static void main(String args[]){
        MedianInAStreamOfNumbers streamMedian = new MedianInAStreamOfNumbers();
        streamMedian.addNumberToStream(1);

        System.out.println(streamMedian.getMedian());

        streamMedian.addNumberToStream(5);
        streamMedian.addNumberToStream(10);
        streamMedian.addNumberToStream(12);
        streamMedian.addNumberToStream(2);
        System.out.println(streamMedian.getMedian()); // should be 5

        streamMedian.addNumberToStream(3);
        streamMedian.addNumberToStream(8);
        streamMedian.addNumberToStream(9);
        System.out.println(streamMedian.getMedian()); // should be 6.5
    }


    PriorityQueue<Integer> lower;
    PriorityQueue<Integer> higher;

    public MedianInAStreamOfNumbers(){
        higher = new PriorityQueue<>();
        lower = new PriorityQueue<>(10, new MaxHeapComparator());
    }


    private double getMedian() {

        return 0;
    }

    private void addNumberToStream(int i) {
    }


    /**
     * Note that output is effective median of integers read from the stream so far.
     * Such an algorithm is called online algorithm.
     * Any algorithm that can guarantee output of i-elements after processing i-th element, is said to be online algorithm.
     */


    private class MaxHeapComparator implements Comparator<Integer>{

        public int compare(Integer o1, Integer o2){
            return o2.compareTo(o1);
        }

    }



}

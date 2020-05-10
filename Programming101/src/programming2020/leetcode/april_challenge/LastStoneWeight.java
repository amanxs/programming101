package programming2020.leetcode.april_challenge;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int arr[] = {2,4,1,1,1};
        System.out.println(lastStoneWeight(arr));
    }

    public static int lastStoneWeight(int[] arr) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Comparator.reverseOrder());

        for(int i=0; i<arr.length; i++){
            maxHeap.add(arr[i]);
        }

        while(maxHeap.size()>1){
            int largest = maxHeap.poll();
            int secondLargest = maxHeap.poll();
            maxHeap.add(largest-secondLargest);
        }

        return maxHeap.poll();
    }

    private class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}

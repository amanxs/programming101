package coding2020.paytm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinderInRunningIntegers {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());// new PriorityQueue<>((a,b) -> b.compareTo(a))

    public double getMedian(){
        if((minHeap.size() + maxHeap.size())%2 == 0){// or minHeap.size() == maxHeap.size()
            return ((maxHeap.peek() + minHeap.peek())/ 2.0);
        }
        else
            return maxHeap.peek();
    }

    public void addNum(int num){
        if(maxHeap.isEmpty() || maxHeap.peek()>= num){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        balanceHeaps();
    }

    public void balanceHeaps(){
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }
        else if(maxHeap.size()<minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */


    public static void main(String[] args) {

    }


}

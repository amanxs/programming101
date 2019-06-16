package programming2019.dataStructures;

import programming2019.sorting.Sorting;

/**
 * The priority queue is maintained in a heap-ordered complete binary tree in the array pq[] with pq[0] unused
 * and the N keys in the priority queue in pq[1] through pq[N].
 * To implement insert(), we increment N, add the new element at the end, then use swim() to restore the heap order.
 * For delMax(), we take the value to be returned from pq[1], then move pq[N] to pq[1], decrement the size of the heap,
 * and use sink() to restore the heap condition.
 * We also set the now-unused position pq[N+1] to null to allow the system to reclaim the memory associated with it.
 * Code for dynamic array resizing is omitted
 */

public class BinaryHeap<Key extends Comparable<Key>> {
    private Key pq[];
    private int N = 0;

    public BinaryHeap(int maxN){
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public static void sort(Comparable a[]){
        // First we need to heapify the array
        /*
        If the two children of a node are heaps, then calling sink() on that node makes the subtree rooted at the par- ent a heap.
        This process establishes the heap order inductively.
        The scan starts halfway back through the array because we can skip the subheaps of size 1.
        The scan ends at position 1, when we finish building the heap with one call to sink().
         */
        int N = a.length;
        for (int i = N/2; i >=1 ; i--) {
            sink(a,i, N);
        }
        /*The for loop constructs the heap; then the while loop exchanges the largest element a[1] with a[N] and then repairs the heap,
        continuing until the heap is empty. Decrementing the array indices in the implementations of swap() and less() gives an \
        implementation that sorts a[0] through a[N-1], consistent with our other sorts.*/

        while(N>1){
            Sorting.swap(a, 1, N--);
            sink(a,1,N);
        }
    }


    private static void sink(Comparable[] a, int i, int n) {

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * Insert. We add the new Key at the end of the array, increment the size of the heap, and then swim up through the heap
     * with that Key to restore the heap condition.
     * <p>
     * Remove the maximum. We take the largest Key off the top, put the item from the end of the heap at the top,
     * decrement the size of the heap, and then sink down through the heap with that Key to restore the heap condition.
     *
     */

    public void insert(Key key){
        pq[++N] = key;
        swim(N);
    }

    public Key extractMax(){
        Key max = pq[1];
        swap(1, N--);
        pq[N+1] = null;     // Avoid Loitering
        sink(1);
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swap(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 0 && less(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k < N) {
            int j = 2 * k;
            if (less(j, j + 1)) j++;
            if (less(k, j)) {
                swap(k, j);
                k = j;
            } else
                break;
        }
    }

}

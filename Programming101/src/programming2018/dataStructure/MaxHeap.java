package programming2018.dataStructure;

public class MaxHeap<Key extends Comparable<Key>> {

	// heap-ordered complete binary tree  in pq[1..N] with pq[0] unused
	
	
	/*In an N-key priority queue, the heap algorithms require no more than 1 + lg N compares for insert
	 * and no more than 2lg N compares for remove the maximum.
	 */
	
	private Key[] pq; 
	private int N = 0;
	
	
	public MaxHeap(int maxN){  		
		pq = (Key[]) new Comparable[maxN+1]; 		
    }

	public boolean isEmpty(){
		return N == 0;		
	}

	public int size(){  
	return N;
	}
	
	public void insert(Key v){
		pq[++N] = v;
		swim(N);
		
	}
	
	public void delMAx(){
		
		Key max = pq[1];
		swap(1,N--);
		pq[N+1] = null;
		sink(1);
		
	}

	private boolean less(int i, int j){
	
		return pq[i].compareTo(pq[j]) < 0;
		
	}
	  private void swap(int i, int j){
		
		  Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;
		  
	  }
    
    private void swim(int k){
    	while(k>1 && less(k/2, k)){    			
    		swap(k/2, k);
    		k=k/2;
    	}
    }
   
    private void sink(int k){
    
    	while(2*k <= N){
    		
    		int j = 2*k;
    	
    		if (less(j, 2*k+1)) {
			j++;
    		}
            
    		if (!less(k, j)) break;
            
    		swap(j, k);
    		k = j;
		}
    	
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

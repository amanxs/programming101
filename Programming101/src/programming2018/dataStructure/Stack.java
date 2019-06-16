package programming2018.dataStructure;

import java.util.Iterator;

/**
 * 
 * @author Aman.Arora
 * This (Algorithm 1.1) is an implementation of our Stack API that resizes the array,
 * allows clients to make stacks for any type of data, and supports client use of foreach
 * to iterate through the stack items in LIFO order.
 */
public class Stack<Item> implements Iterable<Item> {
	
	
	private Item[] a = (Item[]) new Object[1];
	private int N = 0;
	
	
	
	/**
	 * is the stack empty?
	 * @return boolean
	 */	
	public boolean isEmpty() {
		   
		   return N == 0;
		      
	}
	   
	/**
	 * number of strings on the stack
	 * @return N
	 */	
	public int size(){
		   
		   return N;    
	}
	
	
	/**
	 * Add item to top of stack.
	 * @param item
	 */
	public void push(Item item){
		if(a.length==N)
			resize(2*N);
		a[N] = item;
		
	}


	/**
	 * Remove item from top of stack.
	 * @return
	 */
	public Item pop(){
		Item item = a[--N];
        a[N] = null;  // Avoid loitering.
        return item ;
		
	}
	
	/**
	 * Move stack to a new array of size max.
	 * @param size
	 */
	private void resize(int size) {
		
		Item[] b = (Item[]) new Object[size];
		
		for(int i=0; i<N; i++){
			b[i] = a[i];
		}
		
		a = b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<Item> iterator() {
	       return new ReverseArrayIterator();
	       
	}
	private class ReverseArrayIterator implements Iterator<Item>
	{
		// Support LIFO iteration.
        private int i = N;
        public boolean hasNext() {  return i > 0;   }
        public    Item next()    {  return a[--i];  }
        public    void remove()  {                  }
	}

}

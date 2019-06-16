package programming2018.dataStructure;

import java.util.Iterator;


public class Queue<Item> implements Iterable<Item>{
	
	private Node head;
	private int N;
	
	private class Node {
		Item item;
		Node next;
	}
	
	
	public static void main(String[] args){
		
	}
	
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public int size(){
		return N;
	}
	
	/**
	 * Add item to the end of the list.
	 * @param item
	 */
	public void enque(Item item){

		Node new_node = new Node();
		new_node.item = item;
		 
		if(head==null){
			head = new_node;
		}
		
		new_node.next = null;
		
		for(Node last = head; last!=null; last = last.next){
			last.next = new_node;
		}
        N++;
	}
	
	/**
	 * Remove item from the beginning of the list.
	 * @return
	 */
	public Item deque(){
		
		Node oldHead = head;
		
		head = oldHead.next;
		oldHead.next = null;
        N--;
		return oldHead.item;
	}

	 @Override
		public Iterator<Item> iterator() {
			return new ListIterator();
		}
	    private class ListIterator implements Iterator{

	    	private Node current = head;
			@Override
			public boolean hasNext() {
				return N>0;
			}

			@Override
			public Item next() {
				current = current.next;
				return current.item;
			}

			@Override
			public void remove() {
				
			}
	    	
	    }
	

}

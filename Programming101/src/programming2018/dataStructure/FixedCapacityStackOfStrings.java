package programming2018.dataStructure;

import java.util.Scanner;

public class FixedCapacityStackOfStrings {
	
	private  String[] a ;
	private int N;      // size
	   
	
	/**
	 * create an empty stack of capacity cap
	 * @param cap
	 */
	public FixedCapacityStackOfStrings(int cap) {
		a = new String[cap];
	}
	

	/**
	 * is the stack empty?
	 * @return
	 */	
	public boolean isEmpty() {
		   
		   return N == 0;
		      
	}
	   
	/**
	 * number of strings on the stack
	 * @return
	 */	
	public int size(){
		   
		   return N;    
	}
	
	/**
	 * add a string
	 */
	public void push(String item){
		a[N++] = item;
		
	}
	
	/**
	 * remove the most recently added string
	 * @return
	 */
	public String pop(){
		return a[--N];
		
	}
	
	
	public static void main(String[] args) {
		
		 FixedCapacityStackOfStrings s;
		   s = new FixedCapacityStackOfStrings(100);
		   
		   Scanner scan = new Scanner(System.in);    
			
		   while (scan.hasNext())
		   {
		      String item = scan.nextLine();
		      if (!item.equals("-"))
		           s.push(item);
		      else if (!s.isEmpty()) System.out.print(s.pop() + " ");
		}
		   System.out.println("(" + s.size() + " left on stack)");

	}

}

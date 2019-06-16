package programming2018.dataStructure;

public class LinkedList<Item>  {
	
	  private Node head;  // head of list
	 	 
	    /* Linked list Node*/	
	 private class Node{
		
		Item item;
		Node next;
				
	}

	 /* Drier program to test above functions. Ideally this function
     should be in a separate user class.  It is kept here to keep
     code compact */
  public static void main(String[] args)
  {
      /* Start with the empty list */
      LinkedList<Integer> llist = new LinkedList<Integer>();

      // Insert 6.  So linked list becomes 6->NUllist
      llist.append(6);

      // Insert 7 at the beginning. So linked list becomes
      // 7->6->NUllist
      llist.add(7);

      // Insert 1 at the beginning. So linked list becomes
      // 1->7->6->NUllist
      llist.add(1);

      // Insert 4 at the end. So linked list becomes
      // 1->7->6->4->NUllist
      llist.append(4);

      // Insert 8, after 7. So linked list becomes
      // 1->7->8->6->4->NUllist
      llist.insertAfter(llist.head.next, 8);

      System.out.println("\nCreated Linked list is: ");
      llist.printList();
  }
	
  
  
/**
 * This function prints contents of linked list starting from the given node 
 */

  public void printList()
  {
      Node tnode = head;
      while (tnode != null)
      {
          System.out.print(tnode.item+" ");
          tnode = tnode.next;
      }
  }
  
/**
 * Add a node at the front: (A 4 steps process)
 * @param new_data
 * Time complexity of push() is O(1) as it does constant amount of work.
 */
	 
	 /* This function is in LinkedList class. Inserts a
	   new Node at front of the list. This method is 
	   defined inside LinkedList class shown above */
	public void add(Item new_data)
	{
	    /* 1 & 2: Allocate the Node &
	              Put in the data*/
	    Node new_node = new Node();
	 
	    new_node.item = new_data;
	    
	    /* 3. Make next of new Node as head */
	    new_node.next = head;
	 
	    /* 4. Move the head to point to new Node */
	    head = new_node;
	}
	
/**
 * 	Add a node after a given node: (5 steps process)
 * @param prev_node
 * @param new_data
 * Time complexity of insertAfter() is O(1) as it does constant amount of work.
 */	
	/* This function is in LinkedList class.
	   Inserts a new node after the given prev_node. This method is 
	   defined inside LinkedList class shown above */
	public void insertAfter(Node prev_node, Item new_data)
	{
	    /* 1. Check if the given Node is null */
	    if (prev_node == null)
	    {
	        System.out.println("The given previous node cannot be null");
	        return;
	    }
	 
	    /* 2. Allocate the Node &
	       3. Put in the data*/
	    Node new_node = new Node();
	    new_node.item = new_data;
	 
	    /* 4. Make next of new Node as next of prev_node */
	    new_node.next = prev_node.next;
	 
	    /* 5. make next of prev_node as new_node */
	    prev_node.next = new_node;
	}

/**
 * Add a node at the end: (6 steps process)
 * @param new_data
 */
	/* Appends a new node at the end.  This method is 
	   defined inside LinkedList class shown above */
	public void append(Item new_data)
	{
	    /* 1. Allocate the Node &
	       2. Put in the data
	       3. Set next as null */
	    Node new_node = new Node();
	    new_node.item = new_data
	 
	    /* 4. If the Linked List is empty, then make the
	           new node as head */;
	    if (head == null)
	    {
	        head = new Node();
	        head.item=new_data;
	        return;
	    }
	 
	    /* 4. This new node is going to be the last node, so
	         make next of it as null */
	    new_node.next = null;
	 
	    /* 5. Else traverse till the last node */
	    Node last = head; 
	    while (last.next != null)
	        last = last.next;
	 
	    /* 6. Change the next of last node */
	    last.next = new_node;
	    return;
	}
	
/**
 * Given a key, deletes the first occurrence of key in linked list 	
 * @param item
 */
	public void deleteNode(Item item){
	
		Node oldHead = head;

		// If head node itself holds the key to be deleted
		if(oldHead!=null && head.item.equals(item)){
			head = head.next;
			oldHead = null;
			return;
			
		}
		/*Search for the key to be deleted, keep track of the previous node
		 *  as we need to change prev.next
		*/
		for(Node node = head; node!=null; node= node.next ){
			
			if(item.equals(node.next.item))
				node.next = node.next.next;
			node.next.next = null;
			
		}
	}
	
/**
 * Returns count of nodes in linked list	
 * @return
 */
	public int getNodeCount() {
		int count = 0;
		Node node = head;
		while(node!=null){
			count++;
			node = node.next;
		}
		return count;
	}

	
/**
 * 	
 */	
	public void reverseLinkedList(){
		
	}
	
	public void swapNodes(){
		
	}
	
}

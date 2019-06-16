package programming2018.dataStructure;


/**
 * In many applications, it makes sense to allow clients to refer to items that are already on the priority queue.
 * One easy way to do so is to associate a unique integer index with each item.
 * Moreover, it is often the case that clients have a universe of items of a known size N
 * and perhaps are using (parallel) arrays to store information about the items,
 * so other unrelated client code might already be using an integer index to refer to items
 * @author Aman.Arora
 *
 * @param <Item>
 */
public interface IndexMinHeap<Item extends Comparable<Item>> {

	//create a priority queue of capacity maxN with possible indices between 0 and maxN-1
			
	//	insert item; associate it with k
	void insert(int k, Item item); 
	
	//change the item associated with k to item
	void change(int k, Item item);
	
	//	is k associated with some item?
	boolean contains(int k);
	
	//	remove k and its associated item
	void delete(int k);
	
	//	return a minimal item
	Item min();
	
	//	return a minimal item’s index
	int minIndex();
	
//	remove a minimal item and return its index is the priority queue empty?	
	int delMin();
	
	boolean isEmpty();

	//	number of items in the priority queue
	int size();
}

/*
package programming2018.Collections;

import java.util.Map;

public class HashMapTest<K, V> {

	public static void main(programming2018.String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public void put(K key, V value){
	
		
	}
	
	public V get(K key){
		
		return null;
		
	}
	
	
	// the "rehash" function in JAVA 7 that takes the hashcode of the key
	static int hash(int h) {
	    h ^= (h >>> 20) ^ (h >>> 12);
	    return h ^ (h >>> 7) ^ (h >>> 4);
	}
	
	// the "rehash" function in JAVA 8 that directly takes the key
	static final int hash(Object key) {
	    int h;
	    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	    }
	
	// the function that returns the index from the rehashed hash
	static int indexFor(int h, int length) {
	    return h & (length-1);
	}
	
	
	class Entry<K,V> implements Map.Entry<K, V>{

		private K key;
		private V value;
		Entry<K,V> next;
		int hash;
		
		
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public V setValue(V value) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
*/

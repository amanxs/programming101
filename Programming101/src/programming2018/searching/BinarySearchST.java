package programming2018.searching;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;
	private int N;

	public BinarySearchST(int capacity) { // See Algorithm 1.1 for standard
											// array-resizing code.
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}

	public int size() {
		return N;
	}

	public Value get(Key key) {
		if (isEmpty())
			return null;
		int i = rank(key, 0, N);
		if (i < N && keys[i].compareTo(key) == 0)
			return vals[i];
		else
			return null;
	}

	private boolean isEmpty() {
		return false;
	}

	public void put(Key key, Value val) { // Search for key. Update value if
											// found; grow table if new.
		int i = rank(key, 0, N);
		if (i < N && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}
		for (int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}

	public void delete(Key key) {
		// See Exercise 3.1.16 for this method.
	}

	//rank using recursive strategy
	public int rank(Key key, int lo, int hi) {
		if (hi < lo)
			return lo;
		int mid = lo + (hi - lo) / 2;
		int cmp = key.compareTo(keys[mid]);
		if (cmp < 0)
			return rank(key, lo, mid - 1);
		else if (cmp > 0)
			return rank(key, mid + 1, hi);
		else
			return mid;
	}

	
	// rank using loop
	public int rank(Key key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}
}
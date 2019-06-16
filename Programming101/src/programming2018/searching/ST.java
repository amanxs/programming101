package programming2018.searching;

public interface ST<Key extends Comparable<Key>,Value> {
    void put(Key key, Value value);
    Value get(Key key);
    void delete(Key key);
    boolean contains(Key key);
    boolean isEmpty();
    int size();
    Key min();
    Key max();
    Key floor(Key key);
    Key ceiling(Key key);
    int rank(Key key);
    Iterable<Key> keys(); // All the keys in the table, in sorted order.
    Iterable<Key> keys(Key lo, Key hi); // Keys in [lo...hi] in sorted orfer
}

package programming2018.Collections;

import java.util.*;

public class MultiMap<K,V> {

    private Map<K, Collection<V>> map = new HashMap<>();

    public void put(K key, V value){
        if(map.get(key) == null)
            map.put(key, new ArrayList<>());
        map.get(key).add(value);

    }

    public Collection<V> get(Object key){
        return map.get(key);
    }

    public Set<K> keySet(){
        return map.keySet();
    }

    public Set<Map.Entry<K,Collection<V>>> entrySet(){
        return map.entrySet();
    }

    public Collection<Collection<V>> values(){
        return map.values();
    }

    public int size(){
        int size = 0;
        for(Collection<V> val : values()){
            size += val.size();
        }

        return size;
    }

}

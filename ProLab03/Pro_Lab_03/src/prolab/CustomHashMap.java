package prolab;

	import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

	class KeyValuePair<K, V> {
	    private K key;
	    private V value;

	    public KeyValuePair(K key, V value) {
	        this.key = key;
	        this.value = value;
	    }

	    public K getKey() {
	        return key;
	    }

	    public V getValue() {
	        return value;
	    }
	}

	public class CustomHashMap<K, V> {
	    private static final int DEFAULT_CAPACITY = 16;
	    private List<List<KeyValuePair<K, V>>> buckets;

	    public CustomHashMap() {
	        this(DEFAULT_CAPACITY);
	    }

	    public CustomHashMap(int capacity) {
	        this.buckets = new ArrayList<>(capacity);
	        for (int i = 0; i < capacity; i++) {
	            buckets.add(new ArrayList<>());
	        }
	    }

	    private int hash(K key) {
	        return key.hashCode() % buckets.size();
	    }

	    public void put(K key, V value) {
	        int index = hash(key);
	        List<KeyValuePair<K, V>> bucket = buckets.get(index);

	        for (KeyValuePair<K, V> entry : bucket) {
	            if (entry.getKey().equals(key)) {
	                entry = new KeyValuePair<>(key, value);
	                return;
	            }
	        }

	        bucket.add(new KeyValuePair<>(key, value));
	    }

	    public V get(K key) {
	        int index = hash(key);
	        List<KeyValuePair<K, V>> bucket = buckets.get(index);

	        for (KeyValuePair<K, V> entry : bucket) {
	            if (entry.getKey().equals(key)) {
	                return entry.getValue();
	            }
	        }

	        return null;
	    }

	    


	  
	}

	
	


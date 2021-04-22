package leetcode;

import java.util.LinkedHashMap;
import java.util.Set;

public class LRUCache146 {
	
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(2);
		lru.put(2,1);
		lru.toString();
		lru.put(1,1);
		lru.toString();
		lru.put(2,3);
		lru.toString();
		lru.put(4,1);
		lru.toString();
		System.out.println(lru.get(1));
		System.out.println(lru.get(2));
		lru.toString();
	}
	
	static class LRUCache {
		
		public String toString() {
			Set<Integer> set = cache.keySet();
			StringBuilder sb = new StringBuilder();
			for(Integer i : set) {
				sb.append(i+" ");
			}
			System.out.println("cache:"+sb.toString());
			return sb.toString();
		}
		
	    private LRUContainer<Integer, Integer> cache= new LRUContainer<Integer, Integer>(10);
	 
	    public LRUCache(int capacity) {
	        cache = new LRUContainer<Integer, Integer>(capacity);
	    }
	    
	    public int get(int key) {
	        Integer value = cache.get(key);
	        if(value == null){
	            return -1;
	        }else{
	        	cache.remove(key);
	            cache.put(key, value);
	            return value;
	        }
	    }
	    
	    public void put(int key, int value) {
	    	if(cache.containsKey(key))
	    		cache.remove(key);
	        cache.put(key, value);
	    }
	 
	    class LRUContainer<K, V> extends LinkedHashMap<Integer, Integer>{
	        private final int maxSize;
	 
	        public LRUContainer(int maxSize){
	            super(maxSize, 1);
	            this.maxSize = maxSize;
	        }
	 
	        @Override
	        protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest){
	            return this.size() > this.maxSize;
	        }
	        
	        
	    }
	}

}

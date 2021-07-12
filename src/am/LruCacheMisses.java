package am;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class LruCacheMisses {

	public static void main(String[] args) {
		List<Integer> pages = new ArrayList<Integer>();
		pages.add(1);
		pages.add(2);
		pages.add(1);
		pages.add(3);
		pages.add(1);
		pages.add(1);
		System.out.println(lruCacheMisses(6, pages, 2));
	}

	/**
	 * LeastRecently-Used
	 * 
	 * @param num, the number of pages
	 * @param pages, the pages requested
	 * @param maxCacheSize, the size of the cache
	 * @return integer representing the number of cache misses.
	 */
	private static int lruCacheMisses(int num, List<Integer> pages, int maxCacheSize) {
		LRUCache<Integer, Integer> cache = new LRUCache<Integer, Integer>(maxCacheSize);
		int miss = 0;

		for (Integer page : pages) {
			if (cache.put(page, 1) == null) {
				miss++;
			}
		}

		return miss;
	}

	static class LRUCache<K, V> extends LinkedHashMap<Integer, Integer> {
		private final int maxCacheSize;

		public LRUCache(int maxCacheSize) {
			super(maxCacheSize, 1);
			this.maxCacheSize = maxCacheSize;
		}

		@Override
		protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
			return this.size() > this.maxCacheSize;
		}
	}

}

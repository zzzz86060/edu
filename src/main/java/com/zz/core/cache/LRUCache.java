package com.zz.core.cache;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * 手写LRUCache 缓存工具类
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 1L;
    protected int maxElements;

    public LRUCache(int maxSize) {
        super(maxSize, 0.75F, true);
        this.maxElements = maxSize;
    }

    protected boolean removeEldestEntry(Entry<K, V> eldest) {

        return this.size() > this.maxElements;
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(3);
        cache.put("k1", 1);
        cache.put("k2", 2);
        cache.put("k3", 3);
        cache.put("k4",4);
    }

    public static void print(LRUCache<String, Integer> cache) {
        cache.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}

package com.zz.core.cache;

import java.util.ArrayList;
import java.util.List;

public class LocalCache {

    /**
     * 创建lru 缓存
     */
    private static LRUCache<String, Object> lRUCache =
            new LRUCache<String, Object>(100);

    /**
     * put存入数据
     *
     * @param key
     * @param data
     */
    public static void put(String key, Object data) {
        lRUCache.put(key, data);
    }

    /**
     * 从缓存中移除数据
     *
     * @param key
     */
    public static void remove(String key) {
        lRUCache.remove(key);
    }

    /**
     * 从缓存中获取到数据
     *
     * @param key
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T get(String key, T t) {
        return (T) lRUCache.get(key);
    }

    public static void main(String[] args) {
        List<String> data1 = new ArrayList<String>();
        data1.add("1");
        data1.add("2");
        data1.add("3");
        data1.add("4");
        LocalCache.put("zz", data1);
        List<String> data2 = new ArrayList<String>();
        data2 = LocalCache.get("zz", data2);
        System.out.println(data2);
    }
}
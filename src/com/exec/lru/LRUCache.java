package com.exec.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/2/23
 * @version: 1.0.0
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }

    Map<Integer,Integer> cache = new LinkedHashMap();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        // 不存在
        if(!cache.containsKey(key)){
            return -1;
        }
        // 存在
        makeRecently(key,cache.get(key));
        return cache.get(key);
    }

    public void put(int key, int value) {
        // 如果已有，更新值+移到最新位置
        if(cache.containsKey(key)){
            makeRecently(key,value);
            return;
        }
        // 如果容量满，移除最旧的一个 == 队首元素
        if(cache.size() >= capacity){
            int oldKey = cache.keySet().iterator().next();
            cache.remove(oldKey);
        }
        cache.put(key,value);
    }


    // 辅助方法 使得指定k-v成为最新使用对象 == 移到队首
    public void makeRecently(int key,int value){
        // 移除原有的处于链表中间的节点
        cache.remove(key);
        // 加到队尾 ，队尾=新，队首=旧
        cache.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
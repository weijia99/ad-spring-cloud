package com.imooc.ad.index;

public interface IndexAware<K,V> {
//    使用kv来当做索引
    V get(K key);

    void add(K key, V value);

    void update(K key, V value);

    void delete(K key, V value);
}

package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public final void put(K key, V value) {
        cache.putIfAbsent(key, new SoftReference<>(value));
    }

    public final V get(K key) {
        V value = null;
        SoftReference<V> reference = cache.get(key);
        if (reference != null) {
            value = reference.get();
        }
        return value;
    }

    protected abstract V load(K key);

}
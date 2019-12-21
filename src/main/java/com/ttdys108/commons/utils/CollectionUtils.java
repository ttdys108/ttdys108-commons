package com.ttdys108.commons.utils;

import java.util.*;

public class CollectionUtils extends org.springframework.util.CollectionUtils {

    public static <K, V> Map<K, V> ofMap(K key, V value) {
        Map<K, V> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

    public static <T> List<T> ofList(T val) {
        List<T> list = new ArrayList<>();
        list.add(val);
        return list;
    }

    public static <T> Set<T> ofSet(T val) {
        Set<T> set = new HashSet<>();
        set.add(val);
        return set;
    }

}

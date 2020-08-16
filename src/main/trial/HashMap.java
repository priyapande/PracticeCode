package main.trial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HashMap {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.remove(14);
        map.get(4);
        map.put(7,3);
        map.put(11,1);
        map.put(12,1);
        System.out.println(map.get(7));
        map.put(1,19);
        map.put(0,3);
        map.put(1,8);
        map.put(2,6);
        System.out.println(map.get(2));
    }
}

class MyHashMap {
    private static int INITIAL_CAPACITY = 0;
    private static int CURRENT_CAPACITY = 16;
    List<Entry<Integer, Integer>> buckets;

    /** Initialize your data structure here. */
    public MyHashMap() {
        Entry<Integer, Integer>[] temp = new Entry[16];
        buckets = Arrays.asList(temp);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        if(INITIAL_CAPACITY>=CURRENT_CAPACITY-2) {
            increaseSize();
        }
        Entry<Integer,Integer> e = new Entry<>(key, value);
        int i = index(e.hashCode());

        if(buckets.size() > i && buckets.get(i)!=null) {
            Entry<Integer, Integer> entry = buckets.get(i);
            Entry<Integer, Integer> prev = null;
            while(entry!=null) {
                if(entry.equals(e)) {
                    entry.value = value;
                    return;
                } else {
                    prev = entry;
                    entry = entry.next;
                }
            }
            prev.next = e;
        } else {
            buckets.add(i, e);
        }
        INITIAL_CAPACITY++;
    }

    private void increaseSize() {
        List<Entry<Integer, Integer>> newBucket = Arrays.asList(new Entry[CURRENT_CAPACITY*2]);
        for(Entry<Integer, Integer> entry: buckets) {
            int i = index(entry.hashCode());
            newBucket.add(i, entry);
        }
        buckets = newBucket;
        CURRENT_CAPACITY*=2;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = index(Objects.hash(key));
        if(buckets.size() <= i) return -1;
        Entry<Integer, Integer> entry = buckets.get(i);
        Entry<Integer, Integer> e = new Entry<>(key, 0);
        if(entry==null) return -1;
        while(entry!=null) {
            if(entry.equals(e)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = index(Objects.hash(key));
        if(i>=buckets.size()) return;
        Entry<Integer, Integer> entry = buckets.get(i);
        if(entry==null) return;

        Entry<Integer, Integer> e = new Entry<>(key, 0);
        Entry<Integer, Integer> prev = null;

        while(entry!=null) {
            if(entry.equals(e)) {
                if(prev==null) {
                    entry = entry.next;
                    buckets.remove(i);
                    buckets.add(i, entry);
                    INITIAL_CAPACITY--;
                    return;
                }
                if(entry.next==null) {
                    prev.next = null;
                    INITIAL_CAPACITY--;
                    return;
                }
                entry.next = entry.next.next;
                INITIAL_CAPACITY--;
                return;
            }
            prev = entry;
            entry = entry.next;
        }
    }

    private int index(int hash) {
        return hash%CURRENT_CAPACITY;
    }
}

class Entry<K extends Number,V> {
    final K key;
    V value;
    Entry<K, V> next;

    Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entry<?, ?> entry = (Entry<?, ?>) o;
        return key.equals(entry.key);
    }

    @Override
    public int hashCode() {
        //Integer.ha
        return Objects.hash(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
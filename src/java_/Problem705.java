package java_;

import java.util.LinkedList;
import java.util.List;


    /*
    Design a HashSet without using any built-in hash table libraries.

    Implement MyHashSet class:

    void add(key) Inserts the value key into the HashSet.

    bool contains(key) Returns whether the value key exists in the HashSet or not.

    void remove(key) Removes the value key in the HashSet.

    If key does not exist in the HashSet, do nothing.
     */

public class Problem705 {

    private int numBuckets = 15000;
    List<Integer>[] buckets;

    public Problem705() {
        buckets = new LinkedList[numBuckets];
    }

    private int hashFunction(int key) {
        return key % numBuckets;
    }

    public void add(int key) {
        int i = hashFunction(key);
        if (buckets[i] == null) {
            buckets[i] = new LinkedList<>();
        }
        if (buckets[i].indexOf(key) == -1) {
            buckets[i].add(key);
        }
    }

    public void remove(int key) {
        int i = hashFunction(key);
        if (buckets[i] == null) {
            return;
        }
        if (buckets[i].indexOf(key) != -1) {
            buckets[i].remove((Integer) key);
        }
    }

    public boolean containsKey(int key) {
        int i = hashFunction(key);
        return buckets[i] != null && buckets[i].indexOf(key) != -1;
    }
}

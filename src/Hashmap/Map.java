package Hashmap;

import java.util.ArrayList;

public class Map<K, V> {
    ArrayList<MapNode<K, V>> buckets;
    int count;
    int numBuckets;

    public Map() {
        buckets = new ArrayList<>();
        numBuckets = 20;
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
    }

    public int size() {
        return count;
    }

    private void reHash() {
        ArrayList<MapNode<K, V>> temp = buckets;
        buckets=new ArrayList<>();
        for(int i=0;i<2*numBuckets;i++){
            buckets.add(null);
        }
        count=0;
        numBuckets=2*numBuckets;
        for(int i=0;i<temp.size();i++){
            MapNode<K,V> head=temp.get(i);
            while(head!=null){
                insert(head.key, head.value);
                head=head.next;
            }
        }
    }

    public boolean search(K key) {
        int bucketIndex = getBucketKey(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.key = key;
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public void delete(K key) {
        if (search(key)) {
            int bucketIndex = getBucketKey(key);
            MapNode<K, V> head = buckets.get(bucketIndex);
            if (head.key.equals(key)) {
                buckets.set(bucketIndex, head.next);
            } else {
                while (head.next.key.equals(key)) {
                    head = head.next;
                }
                head.next = head.next.next;
            }
            count--;
        } else {
            System.out.println("element not found in hashmap");
        }
    }

    private int getBucketKey(K key) {
        int hc = key.hashCode();
        int index = hc % numBuckets;
        return index;
    }

    public void insert(K key, V value) {
        int bucketIndex = getBucketKey(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        // element is already there just update value
        while (head != null) {
            if (head.key.equals(key)) {
                head.key = key;
                return;
            }
            head = head.next;
        }
        head = buckets.get(bucketIndex);
        // else add new element at 0 index of linked list
        MapNode<K, V> newNode = new MapNode<>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        count++;
        double loadFactor = (0.1 * count) / numBuckets;
        if (loadFactor > 0.7) {
            reHash();
        }
    }
}

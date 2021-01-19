package s0400;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;

public class N0460LFUCache {
    Map<Integer, Node> cache;
    Map<Integer, LinkedHashSet<Node>> freqMap;
    int capacity;
    int size;
    int minFreq;

    public N0460LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);
            return;
        }

        if (size == capacity) {
            Node deadNode = removeNode();
            cache.remove(deadNode.key);
            size--;
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addNode(newNode);
        size++;
    }

    void freqInc(Node node) {
        LinkedHashSet<Node> set = freqMap.get(node.freq);
        set.remove(node);
        if (node.freq == minFreq && set.size() == 0) {
            minFreq++;
        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(node);
    }

    void addNode(Node node) {
        freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(node);
        minFreq = 1;
    }

    Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(minFreq);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }


    static class Node {
        int key;
        int value;
        int freq = 1;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return key == node.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

}

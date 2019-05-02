package me.rainstorm.ds.tree;

public interface SymbolTable<Key extends Comparable<Key>, Value> {
    void put(Key key, Value value);

    Value get(Key key);

    void delete(Key key);

    boolean contains(Key key);

    boolean isEmpty();

    int size();

    Key min();

    Key max();

    void deleteMin();

    void deleteMax();
}

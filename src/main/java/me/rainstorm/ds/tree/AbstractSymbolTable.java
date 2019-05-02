package me.rainstorm.ds.tree;

/**
 * @author baochen1.zhang
 * @date 2019.05.02
 */
public abstract class AbstractSymbolTable<Key extends Comparable<Key>, Value>
        implements SymbolTable<Key, Value> {

    TreeNode<Key, Value> root;

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return isEmpty() ? 0 : root.size;
    }
}

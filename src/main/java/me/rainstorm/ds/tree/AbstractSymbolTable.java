package me.rainstorm.ds.tree;

/**
 * @author baochen1.zhang
 * @date 2019.05.02
 */
public abstract class AbstractSymbolTable<Key extends Comparable<Key>, Value>
        implements SymbolTable<Key, Value> {

    TreeNode<Key, Value> root;

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    abstract TreeNode<Key, Value> put(TreeNode<Key, Value> root, Key key, Value value);

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size(root);
    }

    protected int size(TreeNode<Key, Value> root) {
        if (root == null) {
            return 0;
        }
        return root.size;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(TreeNode<Key, Value> root, Key key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp > 0) {
            return get(root.right, key);
        } else if (cmp < 0) {
            return get(root.left, key);
        } else {
            return root.value;
        }
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    @Override
    public Key min() {
        if (isEmpty()) {
            return null;
        }
        return min(root).key;
    }

    protected TreeNode<Key, Value> min(TreeNode<Key, Value> root) {
        TreeNode<Key, Value> min = root;
        while (min.left != null) {
            min = min.left;
        }
        return min;
    }

    @Override
    public Key max() {
        if (isEmpty()) {
            return null;
        }
        return max(root).key;
    }

    protected TreeNode<Key, Value> max(TreeNode<Key, Value> root) {
        TreeNode<Key, Value> max = root;
        while (max.right != null) {
            max = max.right;
        }
        return max;
    }

    @Override
    public void deleteMin() {
        if (isEmpty()) {
            return;
        }
        root = deleteMin(root);
    }

    protected TreeNode<Key, Value> deleteMin(TreeNode<Key, Value> root) {
        return delete(root, min(root).key);
    }

    @Override
    public void deleteMax() {
        if (isEmpty()) {
            return;
        }
        root = deleteMax(root);
    }

    protected TreeNode<Key, Value> deleteMax(TreeNode<Key, Value> root) {
        return delete(root, max(root).key);
    }

    abstract TreeNode<Key, Value> delete(TreeNode<Key, Value> root, Key key);

    boolean isValid() {
        return isValid(root);
    }

    abstract boolean isValid(TreeNode<Key, Value> root);
}

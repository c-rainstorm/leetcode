package me.rainstorm.ds.tree;

/**
 * @author baochen1.zhang
 * @date 2019.05.02
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value>
        extends AbstractSymbolTable<Key, Value> {

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private TreeNode<Key, Value> put(TreeNode<Key, Value> root, Key key, Value value) {
        if (root == null) {
            return new TreeNode<>(key, value);
        }

        int cmp = key.compareTo(root.key);
        if (cmp > 0) {
            root.right = put(root.right, key, value);
        } else if (cmp < 0) {
            root.left = put(root.left, key, value);
        } else {
            root.value = value;
        }

        updateSize(root);
        return root;
    }

    private void updateSize(TreeNode<Key, Value> root) {
        if (root == null) {
            return;
        }

        root.size = size(root.left) + size(root.right) + 1;
    }

    private int size(TreeNode<Key, Value> root) {
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

    private TreeNode<Key, Value> delete(TreeNode<Key, Value> root, Key key) {
        if (root == null) {
            return null;
        }

        int cmp = key.compareTo(root.key);
        if (cmp > 0) {
            root.right = delete(root.right, key);
        } else if (cmp < 0) {
            root.left = delete(root.left, key);
        } else {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                TreeNode<Key, Value> rightMin = min(root.right);
                assert rightMin != null;
                rightMin.right = delete(root.right, rightMin.key);
                rightMin.left = root.left;
                root = rightMin;
            }
        }

        updateSize(root);
        return root;
    }

    @Override
    public Key min() {
        if (isEmpty()) {
            return null;
        }
        return min(root).key;
    }

    private TreeNode<Key, Value> min(TreeNode<Key, Value> root) {
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

    private TreeNode<Key, Value> max(TreeNode<Key, Value> root) {
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

    private TreeNode<Key, Value> deleteMin(TreeNode<Key, Value> root) {
        return delete(root, min(root).key);
    }

    @Override
    public void deleteMax() {
        if (isEmpty()) {
            return;
        }
        root = deleteMax(root);
    }

    private TreeNode<Key, Value> deleteMax(TreeNode<Key, Value> root) {
        return delete(root, max(root).key);
    }

    boolean isValid() {
        return isValid(root);
    }

    private boolean isValid(TreeNode<Key, Value> root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.key.compareTo(root.left.key) <= 0) {
            return false;
        }

        if (root.right != null && root.key.compareTo(root.right.key) >= 0) {
            return false;
        }

        return isValid(root.left) && isValid(root.right);
    }
}

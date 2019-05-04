package me.rainstorm.ds.tree;

/**
 * @author baochen1.zhang
 * @date 2019.05.02
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value>
        extends AbstractSymbolTable<Key, Value> {

    @Override
    TreeNode<Key, Value> put(TreeNode<Key, Value> root, Key key, Value value) {
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

        return afterPut(root, key);
    }

    protected TreeNode<Key, Value> afterPut(TreeNode<Key, Value> root, Key key) {
        // 普通二分查找树不需要做任何操作
        return root;
    }

    void updateSize(TreeNode<Key, Value> root) {
        if (root == null) {
            return;
        }

        root.size = size(root.left) + size(root.right) + 1;
    }

    @Override
    TreeNode<Key, Value> delete(TreeNode<Key, Value> root, Key key) {
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
                rightMin.color = root.color;
                root = rightMin;
            }
        }

        updateSize(root);

        return afterDelete(root);
    }

    protected TreeNode<Key, Value> afterDelete(TreeNode<Key, Value> root) {
        // 普通二分查找树不需要做任何操作
        return root;
    }

    @Override
    boolean isValid(TreeNode<Key, Value> root) {
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

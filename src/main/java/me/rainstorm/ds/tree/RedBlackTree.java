package me.rainstorm.ds.tree;

import static me.rainstorm.ds.tree.TreeNode.BLACK;
import static me.rainstorm.ds.tree.TreeNode.RED;


/**
 * 代码参考 《算法 - 第四版》
 *
 * @author baochen1.zhang
 * @date 2019.05.04
 */
public class RedBlackTree<Key extends Comparable<Key>, Value>
        extends BinarySearchTree<Key, Value> {

    private static boolean isRed(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    @Override
    public void put(Key key, Value value) {
        super.put(key, value);
        root.color = BLACK;
    }

    @Override
    protected TreeNode<Key, Value> afterPut(TreeNode<Key, Value> root, Key key) {
        if (isRed(root.right) && !isRed(root.left)) {
            root = leftRotate(root);
        }
        if (isRed(root.left) && isRed(root.left.left)) {
            root = rightRotate(root);
        }
        if (isRed(root.left) && isRed(root.right)) {
            flipColors(root);
        }

        return root;
    }

    private void flipColors(TreeNode<Key, Value> root) {
        root.color = !root.color;
        root.left.color = !root.left.color;
        root.right.color = !root.right.color;
    }

    private TreeNode<Key, Value> rightRotate(TreeNode<Key, Value> root) {
        assert (root != null) && isRed(root.left);

        TreeNode<Key, Value> newRoot = root.left;

        root.left = newRoot.right;
        newRoot.right = root;
        newRoot.color = root.color;
        root.color = RED;

        updateSize(newRoot.right);
        updateSize(newRoot);

        return newRoot;
    }

    private TreeNode<Key, Value> leftRotate(TreeNode<Key, Value> root) {
        assert (root != null) && isRed(root.right);

        TreeNode<Key, Value> newRoot = root.right;

        root.right = newRoot.left;
        newRoot.left = root;
        newRoot.color = root.color;
        root.color = RED;

        updateSize(newRoot.left);
        updateSize(newRoot);

        return newRoot;
    }

    @Override
    public void delete(Key key) {
        if (isEmpty() || !contains(key)) {
            return;
        }

        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }

        root = delete(root, key);
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }

    @Override
    TreeNode<Key, Value> delete(TreeNode<Key, Value> root, Key key) {
        if (key.compareTo(root.key) < 0) {
            if (!isRed(root.left) && !isRed(root.left.left)) {
                // 2-节点
                root = makeLeftRed(root);
            }
            root.left = delete(root.left, key);
        } else {
            if (isRed(root.left)) {
                root = rightRotate(root);
            }
            if (key.compareTo(root.key) == 0 && (root.right == null)) {
                return null;
            }
            if (!isRed(root.right) && !isRed(root.right.left)) {
                root = makeRightRed(root);
            }
            if (key.compareTo(root.key) == 0) {
                TreeNode<Key, Value> min = min(root.right);
                root.key = min.key;
                root.value = min.value;
                root.right = delete(root.right, min.key);
            } else {
                root.right = delete(root.right, key);
            }
        }

        updateSize(root);

        return afterDelete(root);
    }

    private TreeNode<Key, Value> makeRightRed(TreeNode<Key, Value> root) {
        flipColors(root);

        if (!isRed(root.left.left)) {
            root = rightRotate(root);
            flipColors(root);
        }
        return root;
    }

    private TreeNode<Key, Value> makeLeftRed(TreeNode<Key, Value> root) {
        flipColors(root);

        if (isRed(root.right.left)) {
            root.right = rightRotate(root.right);
            root = leftRotate(root);
            flipColors(root);
        }
        return root;
    }

    @Override
    protected TreeNode<Key, Value> afterDelete(TreeNode<Key, Value> root) {
        return afterPut(root, null);
    }

    @Override
    boolean isValid(TreeNode<Key, Value> root) {
        return super.isValid(root) && isBalanced();
    }

    // do all paths from root to leaf have same number of black edges?
    private boolean isBalanced() {
        int black = 0;     // number of black links on path from root to min
        TreeNode<Key, Value> x = root;
        while (x != null) {
            if (!isRed(x)) {
                black++;
            }
            x = x.left;
        }
        return isBalanced(root, black);
    }

    // does every path from the root to a leaf have the given number of black links?
    private boolean isBalanced(TreeNode<Key, Value> x, int black) {
        if (x == null) {
            return black == 0;
        }
        if (!isRed(x)) {
            black--;
        }
        return isBalanced(x.left, black) && isBalanced(x.right, black);
    }
}

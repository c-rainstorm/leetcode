package me.rainstorm.ds;

import org.junit.Test;

import java.util.UUID;

/**
 * @author baochen1.zhang
 * @date 2019.05.02
 */
public class AVLTree<T> {
    @Test
    public void case1() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(3);
        avlTree.insert(2);
        avlTree.insert(1);
        assert avlTree.isAVL();
        avlTree.insert(4);
        avlTree.insert(5);
        assert avlTree.isAVL();
        avlTree.insert(6);
        assert avlTree.isAVL();
        avlTree.insert(7);
        assert avlTree.isAVL();
        for (int i = 16; i > 7; --i) {
            avlTree.insert(i);
            assert avlTree.isAVL();
        }
    }

    @Test
    public void case2() {
        AVLTree<String> avlTree = new AVLTree<>();
        for (int i = 16; i > 0; --i) {
            avlTree.insert(UUID.randomUUID().toString());
            assert avlTree.isAVL();
        }
    }

    private TreeNode<T> root;

    public void insert(T val) {
        root = insert(root, val);
    }

    private TreeNode<T> insert(TreeNode<T> root, T val) {
        if (root == null) {
            return new TreeNode<>(val);
        }

        if (val instanceof Comparable && root.val instanceof Comparable) {
            int compare = ((Comparable) root.val).compareTo(val);
            if (compare > 0) {
                // 当前节点值比插入值大，后续插到左子树上
                root.left = insert(root.left, val);
                if (height(root.left) - height(root.right) == 2) {
                    if (((Comparable) root.left.val).compareTo(val) > 0) {
                        // 左子树的值较大，新值插入左子树的左侧
                        root = leftSingleRotate(root);
                    } else {
                        root = leftDoubleRotate(root);
                    }
                }
            } else {
                root.right = insert(root.right, val);
                if (height(root.right) - height(root.left) == 2) {
                    if (((Comparable) root.right.val).compareTo(val) < 0) {
                        // 右子树的值较小，新值插入右子树的右侧
                        root = rightSingleRotate(root);
                    } else {
                        root = rightDoubleRotate(root);
                    }
                }
            }
            updateHeight(root);
        }
        return root;
    }

    private TreeNode<T> rightDoubleRotate(TreeNode<T> root) {
        TreeNode<T> newRoot = root.right.left;
        TreeNode<T> rootRight = root.right;

        root.right = newRoot.left;
        rootRight.left = newRoot.right;
        newRoot.left = root;
        newRoot.right = rootRight;

        updateHeight(newRoot.left);
        updateHeight(newRoot.right);
        updateHeight(newRoot);

        assert isAVL(newRoot);

        return newRoot;
    }

    private TreeNode<T> rightSingleRotate(TreeNode<T> root) {
        TreeNode<T> newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;

        updateHeight(newRoot.left);
        updateHeight(newRoot);

        assert isAVL(newRoot);

        return newRoot;
    }

    private TreeNode<T> leftDoubleRotate(TreeNode<T> root) {
        TreeNode<T> newRoot = root.left.right;
        TreeNode<T> rootLeft = root.left;

        rootLeft.right = newRoot.left;
        root.left = newRoot.right;
        newRoot.left = rootLeft;
        newRoot.right = root;

        updateHeight(newRoot.left);
        updateHeight(newRoot.right);
        updateHeight(newRoot);

        assert isAVL(newRoot);

        return newRoot;
    }

    private TreeNode<T> leftSingleRotate(TreeNode<T> root) {
        TreeNode<T> newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;

        updateHeight(newRoot.right);
        updateHeight(newRoot);

        assert isAVL(newRoot);

        return newRoot;
    }

    private boolean isAVL() {
        return isAVL(root);
    }

    private boolean isAVL(TreeNode<T> root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }
        return isAVL(root.left) && isAVL(root.right);
    }

    private void updateHeight(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;
    }

    private int height(TreeNode<T> root) {
        return root == null ? -1 : root.height;
    }

    class TreeNode<U> {
        TreeNode<U> left;
        TreeNode<U> right;
        int height;
        U val;

        public TreeNode(U x) {
            val = x;
            height = 0;
        }
    }

}

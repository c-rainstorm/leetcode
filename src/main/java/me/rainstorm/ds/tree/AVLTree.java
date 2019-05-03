package me.rainstorm.ds.tree;

/**
 * @author baochen1.zhang
 * @date 2019.05.03
 */
public class AVLTree<Key extends Comparable<Key>, Value>
        extends BinarySearchTree<Key, Value> {
    @Override
    TreeNode<Key, Value> put(TreeNode<Key, Value> root, Key key, Value value) {
        if (root == null) {
            return new TreeNode<>(key, value, 1);
        }
        int compare = root.key.compareTo(key);
        if (compare > 0) {
            // 当前节点值比插入值大，后续插到左子树上
            root.left = put(root.left, key, value);
            if (height(root.left) - height(root.right) == 2) {
                if (root.left.key.compareTo(key) > 0) {
                    // 左子树的值较大，新值插入左子树的左侧
                    root = leftSingleRotate(root);
                } else {
                    root = leftDoubleRotate(root);
                }
            }
        } else if (compare < 0) {
            root.right = put(root.right, key, value);
            if (height(root.right) - height(root.left) == 2) {
                if (root.right.key.compareTo(key) < 0) {
                    // 右子树的值较小，新值插入右子树的右侧
                    root = rightSingleRotate(root);
                } else {
                    root = rightDoubleRotate(root);
                }
            }
        } else {
            root.value = value;
        }

        updateSize(root);

        return root;
    }

    private TreeNode<Key, Value> rightDoubleRotate(TreeNode<Key, Value> root) {
        root.right = leftSingleRotate(root.right);

        return rightSingleRotate(root);
    }

    private TreeNode<Key, Value> leftDoubleRotate(TreeNode<Key, Value> root) {
        root.left = rightSingleRotate(root.left);

        return leftSingleRotate(root);
    }

    private TreeNode<Key, Value> rightSingleRotate(TreeNode<Key, Value> root) {
        TreeNode<Key, Value> newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;

        updateSize(newRoot.left);
        updateSize(newRoot);

        return newRoot;
    }

    private TreeNode<Key, Value> leftSingleRotate(TreeNode<Key, Value> root) {
        TreeNode<Key, Value> newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;

        updateSize(newRoot.right);
        updateSize(newRoot);

        return newRoot;
    }

    @Override
    protected void updateSize(TreeNode<Key, Value> root) {
        if (root == null) {
            return;
        }

        super.updateSize(root);
        root.height = Math.max(height(root.left), height(root.right)) + 1;
    }


    private int height(TreeNode<Key, Value> root) {
        return root == null ? 0 : root.height;
    }

    @Override
    protected TreeNode<Key, Value> afterDelete(TreeNode<Key, Value> root) {
        if (root == null) {
            return null;
        }

        int heightDiff = height(root.left) - height(root.right);
        if (Math.abs(heightDiff) <= 1) {
            // 删除后依旧是 AVL 树，直接返回
            return root;
        }

        if (heightDiff > 0) {
            // 左子树高
            int heightDiffLeft = height(root.left.left) - height(root.left.right);
            if (heightDiffLeft > 0) {
                // 左子树的左右子树中，左子树高
                root = leftSingleRotate(root);
            } else {
                // 左子树的左右子树中，右子树高
                root = leftDoubleRotate(root);
            }
        } else {
            // 右子树高
            int heightDiffRight = height(root.right.left) - height(root.right.right);
            if (heightDiffRight > 0) {
                // 右子树的左右子树中，左子树高
                root = rightDoubleRotate(root);
            } else {
                // 右子树的左右子树中，右子树高
                root = rightSingleRotate(root);
            }
        }

        return root;
    }

    @Override
    boolean isValid(TreeNode<Key, Value> root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }

        return isValid(root.left) && isValid(root.right);
    }
}

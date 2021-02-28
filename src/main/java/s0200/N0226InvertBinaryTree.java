package s0200;

import me.rainstorm.ds.TreeNode;

public class N0226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        return doInvert(root);
    }

    private TreeNode doInvert(TreeNode root) {
        if (root == null) return null;

        TreeNode newRight = root.left;
        TreeNode newLeft = root.right;
        root.right = doInvert(newRight);
        root.left = doInvert(newLeft);
        return root;
    }
}

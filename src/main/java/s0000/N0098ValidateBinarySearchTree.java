package s0000;


import me.rainstorm.ds.TreeNode;

/**
 * @author traceless
 */
public class N0098ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    public boolean isValid(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;

        if (lower != null && root.val <= lower) return false;
        if (upper != null && root.val >= upper) return false;

        return isValid(root.left, lower, root.val) && isValid(root.right, root.val, upper);
    }
}

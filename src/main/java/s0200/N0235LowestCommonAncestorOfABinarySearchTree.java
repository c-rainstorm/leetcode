package s0200;

import me.rainstorm.ds.TreeNode;

/**
 * @author traceless
 */
public class N0235LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode target = root;
        while (true) {
            if (target.val > p.val && target.val > q.val) {
                target = target.left;
            } else if (target.val < p.val && target.val < q.val) {
                target = target.right;
            } else {
                break;
            }
        }
        return target;
    }
}

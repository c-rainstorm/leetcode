package contest.weekly131;

import me.rainstorm.ds.TreeNode;
import me.rainstorm.util.TreeNodeUtil;
import org.junit.Test;

/**
 * @author baochen1.zhang
 * @date 2019.04.07
 */
public class N5017SumRootToLeaf {

    private long sum = 0;

    @Test
    public void case1() {
        assert 22 == sumRootToLeaf(TreeNodeUtil.buildTree(new Integer[]{1, 0, 1, 0, 1, 0, 1}));
    }

    public int sumRootToLeaf(TreeNode root) {
        sumRootToLeaf(root, 0);
        return (int) sum;
    }

    private void sumRootToLeaf(TreeNode root, long val) {
        long mod = 1000000007;
        if (root.left == null && root.right == null) {
            sum = (sum + (val << 1) + root.val) % mod;
            return;
        }
        long curVal = ((val << 1) + root.val) % mod;
        if (root.left != null) {
            sumRootToLeaf(root.left, curVal);
        }
        if (root.right != null) {
            sumRootToLeaf(root.right, curVal);
        }
    }
}

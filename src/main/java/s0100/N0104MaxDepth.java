package s0100;

import me.rainstorm.ds.TreeNode;
import me.rainstorm.util.TreeNodeUtil;
import org.junit.Test;

/**
 * @author baochen1.zhang
 * @date 2019.06.17
 */
public class N0104MaxDepth {

    @Test
    public void case1() {
        assert 0 == maxDepth(null);
    }

    @Test
    public void case2() {
        assert 1 == maxDepth(TreeNodeUtil.buildTree(new Integer[]{1}));
    }

    @Test
    public void case3() {
        assert 2 == maxDepth(TreeNodeUtil.buildTree(new Integer[]{1, 2, 3}));
    }

    @Test
    public void case4() {
        assert 3 == maxDepth(TreeNodeUtil.buildTree(new Integer[]{1, 2, 3, 4}));
    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

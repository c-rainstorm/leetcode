package s0100;

import me.rainstorm.ds.TreeNode;
import me.rainstorm.util.TreeNodeUtil;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

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


    /**
     * 递归
     *
     * @TimeComplexity O(n)
     * @SpaceComplexity log(n)
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int bfs(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        for (int count = queue.size(); !queue.isEmpty(); ++level, count = queue.size()) {
            do {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.offer(node.right);
            } while (--count > 0);
        }
        return level;
    }
}

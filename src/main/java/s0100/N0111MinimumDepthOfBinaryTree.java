package s0100;

import me.rainstorm.ds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author traceless
 */
public class N0111MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return root.left == null ? right + 1 : root.right == null ? left + 1 : Math.min(left, right) + 1;
    }

    public int bfs(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        for (int count = queue.size(); !queue.isEmpty(); ++level, count = queue.size()) {
            do {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return level;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            } while (--count > 0);
        }
        return level;
    }
}

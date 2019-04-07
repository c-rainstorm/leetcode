package s0100;

import me.rainstorm.ds.TreeNode;
import me.rainstorm.util.TreeNodeUtil;
import org.junit.Test;

/**
 * [100] 相同的树
 * <p>
 * https://leetcode-cn.com/problems/same-tree/description/
 * <p>
 * algorithms
 * Easy (52.03%)
 * Total Accepted:    18.6K
 * Total Submissions: 35.8K
 * Testcase Example:  '[1,2,3]\n[1,2,3]'
 * <p>
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <p>
 * 输入:       1         1
 * ⁠         / \       / \
 * ⁠        2   3     2   3
 * <p>
 * ⁠       [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入:      1          1
 * ⁠         /           \
 * ⁠        2             2
 * <p>
 * ⁠       [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入:       1         1
 * ⁠         / \       / \
 * ⁠        2   1     1   2
 * <p>
 * ⁠       [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
 *
 * @author baochen1.zhang
 * @date 2019.04.05
 */
public class N0100IsSameTree {
    @Test
    public void case1() {
        Integer[] tree1 = new Integer[]{1, 2, 1};
        Integer[] tree2 = new Integer[]{1, 1, 2};
        assert !isSameTree(TreeNodeUtil.buildTree(tree1), TreeNodeUtil.buildTree(tree2));
    }

    @Test
    public void case2() {
        Integer[] tree1 = new Integer[]{1, 2, 3};
        Integer[] tree2 = new Integer[]{1, 2, 3};
        assert isSameTree(TreeNodeUtil.buildTree(tree1), TreeNodeUtil.buildTree(tree2));
    }

    @Test
    public void case3() {
        Integer[] tree1 = new Integer[]{1, 2};
        Integer[] tree2 = new Integer[]{1, null, 2};
        assert !isSameTree(TreeNodeUtil.buildTree(tree1), TreeNodeUtil.buildTree(tree2));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

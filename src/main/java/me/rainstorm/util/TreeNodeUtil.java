package me.rainstorm.util;

import me.rainstorm.ds.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author baochen1.zhang
 * @date 2019.04.05
 */
public class TreeNodeUtil {
    @Test
    public void case1() {
        Integer[] tree1 = new Integer[]{1, 2, 1};
        TreeNode root = buildTree(tree1);
        Integer[] resultArray = toArray(root);
        assert ArrayUtil.toString(tree1).equals(ArrayUtil.toString(resultArray));
    }

    @Test
    public void case2() {
        Integer[] tree1 = new Integer[]{1, 2, 1, null, 1, null, 1};
        TreeNode root = buildTree(tree1);
        Integer[] resultArray = toArray(root);
        assert ArrayUtil.toString(tree1).equals(ArrayUtil.toString(resultArray));
    }

    @Test
    public void case3() {
        Integer[] tree1 = new Integer[]{1, 2, null, 3, null, null, null, 4};
        TreeNode root = buildTree(tree1);
        Integer[] resultArray = toArray(root);
        assert ArrayUtil.toString(tree1).equals(ArrayUtil.toString(resultArray));
    }

    @Test
    public void case4() {
        Integer[] tree1 = new Integer[]{1, 2, null, 3, null, null, null, 4, null, null, null, null, null, null, null, 5};
        TreeNode root = buildTree(tree1);
        Integer[] resultArray = toArray(root);
        assert ArrayUtil.toString(tree1).equals(ArrayUtil.toString(resultArray));
    }


    public static Integer[] toArray(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int nullNum = 0;
        queue.offer(root);
        while (nullNum != queue.size()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add(null);
                queue.offer(null);
                queue.offer(null);
                nullNum++;
                continue;
            }
            result.add(node.val);
            queue.offer(node.left);
            queue.offer(node.right);
            if (node.left == null) {
                nullNum++;
            }
            if (node.right == null) {
                nullNum++;
            }
        }

        return result.toArray(new Integer[0]);
    }

    public static TreeNode buildTree(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return buildTree(nums, 0);
    }

    private static TreeNode buildTree(Integer[] nums, int index) {
        if (index >= nums.length || nums[index] == null) {
            return null;
        }

        TreeNode root = new TreeNode(nums[index]);
        root.left = buildTree(nums, index * 2 + 1);
        root.right = buildTree(nums, index * 2 + 2);
        return root;
    }
}

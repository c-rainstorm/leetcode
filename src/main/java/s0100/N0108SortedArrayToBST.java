package s0100;

import me.rainstorm.ds.TreeNode;

/**
 * @author baochen1.zhang
 * @date 2019.06.17
 */
public class N0108SortedArrayToBST {


    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new TreeNode(nums[start]);
        } else {
            int mid = (start + end) >> 1;

            TreeNode root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(nums, start, mid - 1);
            root.right = sortedArrayToBST(nums, mid + 1, end);
            return root;
        }
    }
}


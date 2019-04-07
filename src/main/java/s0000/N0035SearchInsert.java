package s0000;

import org.junit.Test;

/**
 * [35] 搜索插入位置
 * <p>
 * https://leetcode-cn.com/problems/search-insert-position/description/
 * <p>
 * algorithms
 * Easy (43.08%)
 * Total Accepted:    37.5K
 * Total Submissions: 87.1K
 * Testcase Example:  '[1,3,5,6]\n5'
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * <p>
 * <p>
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * @author baochen1.zhang
 * @date 2019.04.03
 */
public class N0035SearchInsert {

    @Test
    public void case1() {
        int[] nums = new int[]{1, 3, 5, 6};
        assert searchInsert(nums, 5) == 2;
    }

    @Test
    public void case2() {
        int[] nums = new int[]{1, 3, 5, 6};
        assert searchInsert(nums, 2) == 1;
    }

    @Test
    public void case3() {
        int[] nums = new int[]{1, 3, 5, 6};
        assert searchInsert(nums, 7) == 4;
    }

    @Test
    public void case4() {
        int[] nums = new int[]{1, 3, 5, 6};
        assert searchInsert(nums, 0) == 0;
    }

    @Test
    public void case5() {
        int[] nums = new int[]{1, 3, 5, 6};
        assert searchInsert(nums, 2) == 1;
    }


    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = Math.min(mid + 1, end);
            } else {
                end = Math.max(mid - 1, start);
            }
        }

        if (nums[start] < target) {
            start++;
        }
        return start;
    }
}

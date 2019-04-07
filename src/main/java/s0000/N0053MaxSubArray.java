package s0000;

import org.junit.Test;

/**
 * [53] 最大子序和
 * <p>
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 * <p>
 * algorithms
 * Easy (43.74%)
 * Total Accepted:    46.7K
 * Total Submissions: 106.4K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * <p>
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @author baochen1.zhang
 * @date 2019.04.03
 */
public class N0053MaxSubArray {

    @Test
    public void case1() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assert maxSubArray(nums) == 6;
    }

    @Test
    public void case2() {
        int[] nums = new int[]{-2, -1, -3, -4, -1, -2, -1, -5, -4};
        assert maxSubArray(nums) == -1;
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curMax = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (curMax + nums[i] < nums[i]) {
                curMax = nums[i];
            } else {
                curMax += nums[i];
            }
            max = Math.max(curMax, max);
        }
        return max;
    }
}

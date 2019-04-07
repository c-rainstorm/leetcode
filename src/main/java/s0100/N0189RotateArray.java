package s0100;

import org.junit.Test;

import java.util.Arrays;

/**
 * [189] 旋转数组
 * <p>
 * https://leetcode-cn.com/problems/rotate-array/description/
 * <p>
 * algorithms
 * Easy (36.87%)
 * Total Accepted:    43K
 * Total Submissions: 116.5K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * <p>
 * 说明:
 * <p>
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 *
 * @author baochen1.zhang
 * @date 2019.04.06
 */
public class N0189RotateArray {
    @Test
    public void case1() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        assert "[5, 6, 7, 1, 2, 3, 4]".equals(Arrays.toString(nums));
    }

    @Test
    public void case2() {
        int[] nums = new int[]{-1, -100, 3, 99};
        rotate(nums, 2);
        assert "[3, 99, -1, -100]".equals(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        if (k == nums.length) {
            return;
        }

        // java.util.Collections.rotate1
        for (int rotateStart = 0, moved = 0; moved != nums.length; ++rotateStart) {
            int index = rotateStart;
            do {
                index = (index + k) % nums.length;
                int tmp = nums[rotateStart];
                nums[rotateStart] = nums[index];
                nums[index] = tmp;
                moved++;
            } while (index != rotateStart);
        }
    }
}

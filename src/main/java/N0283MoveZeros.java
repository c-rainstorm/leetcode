import org.junit.Test;

import java.util.Arrays;

/**
 * [283] 移动零
 * <p>
 * https://leetcode-cn.com/problems/move-zeroes/description/
 * <p>
 * algorithms
 * Easy (53.19%)
 * Total Accepted:    40.4K
 * Total Submissions: 75.8K
 * Testcase Example:  '[0,1,0,3,12]'
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * <p>
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author baochen1.zhang
 * @date 2019.04.07
 */
public class N0283MoveZeros {
    @Test
    public void case1() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        assert "[1, 3, 12, 0, 0]".equals(Arrays.toString(nums));
    }

    @Test
    public void case2() {
        int[] nums = new int[]{0, 0, 0, 0, 0};
        moveZeroes(nums);
        assert "[0, 0, 0, 0, 0]".equals(Arrays.toString(nums));
    }

    @Test
    public void case3() {
        int[] nums = new int[]{1, 3, 12};
        moveZeroes(nums);
        assert "[1, 3, 12]".equals(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length && j < nums.length; ) {
            if (nums[i] != 0) {
                i++;
                continue;
            }
            if (i > j) {
                j = i;
            }
            if (nums[j] == 0) {
                j++;
                continue;
            }

            nums[i++] = nums[j++];
            nums[j - 1] = 0;
        }
    }
}

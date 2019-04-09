package s0100;

import org.junit.Test;

/**
 * [136] 只出现一次的数字
 * <p>
 * https://leetcode-cn.com/problems/single-number/description/
 * <p>
 * algorithms
 * Easy (60.01%)
 * Total Accepted:    57.5K
 * Total Submissions: 95.5K
 * Testcase Example:  '[2,2,1]'
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author baochen1.zhang
 * @date 2019.04.10
 */
public class N0136SingleNumber {
    @Test
    public void case1() {
        assert 1 == singleNumber(new int[]{2, 2, 1});
    }

    @Test
    public void case2() {
        assert 4 == singleNumber(new int[]{4, 1, 2, 1, 2});
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}

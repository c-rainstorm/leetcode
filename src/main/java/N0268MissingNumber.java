import org.junit.Test;

/**
 * [268] 缺失数字
 * <p>
 * https://leetcode-cn.com/problems/missing-number/description/
 * <p>
 * algorithms
 * Easy (49.03%)
 * Total Accepted:    16.8K
 * Total Submissions: 34.3K
 * Testcase Example:  '[3,0,1]'
 * <p>
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * <p>
 * <p>
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 * @author baochen1.zhang
 * @date 2019.04.07
 */
public class N0268MissingNumber {
    @Test
    public void case1() {
        assert 2 == missingNumber(new int[]{3, 0, 1});
    }

    @Test
    public void case2() {
        assert 8 == missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
    }

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        long total = (nums.length + 1L) * nums.length / 2;
        for (int i = 0; i < nums.length; ++i) {
            total -= nums[i];
        }
        return (int) total;
    }
}

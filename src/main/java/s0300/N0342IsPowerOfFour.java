package s0300;

import org.junit.Test;

/**
 * [342] 4的幂
 * <p>
 * https://leetcode-cn.com/problems/power-of-four/description/
 * <p>
 * algorithms
 * Easy (44.82%)
 * Total Accepted:    6.9K
 * Total Submissions: 15.3K
 * Testcase Example:  '16'
 * <p>
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 16
 * 输出: true
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: false
 * <p>
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 *
 * @author baochen1.zhang
 * @date 2019.04.10
 */
public class N0342IsPowerOfFour {
    @Test
    public void case1() {
        assert isPowerOfFour(4);
    }

    @Test
    public void case2() {
        assert isPowerOfFour(1);
    }

    @Test
    public void case3() {
        assert !isPowerOfFour(5);
    }

    @Test
    public void case4() {
        assert !isPowerOfFour(-1);
    }

    @Test
    public void case5() {
        assert !isPowerOfFour(8);
    }

    public boolean isPowerOfFour(int num) {
        if (num < 0 || (num & (num - 1)) != 0) {
            return false;
        }

        return (num & 0x55555555) != 0;
    }
}

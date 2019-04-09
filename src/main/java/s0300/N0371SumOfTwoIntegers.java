package s0300;

import org.junit.Test;

/**
 * [371] 两整数之和
 * <p>
 * https://leetcode-cn.com/problems/sum-of-two-integers/description/
 * <p>
 * algorithms
 * Easy (53.88%)
 * Total Accepted:    8.8K
 * Total Submissions: 16.5K
 * Testcase Example:  '1\n2'
 * <p>
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = 1, b = 2
 * 输出: 3
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 * @author baochen1.zhang
 * @date 2019.04.09
 */
public class N0371SumOfTwoIntegers {
    @Test
    public void case1() {
        assert 3 == getSum(1, 2);
    }

    @Test
    public void case2() {
        assert 0 == getSum(0, 0);
    }

    @Test
    public void case3() {
        assert 2 == getSum(-1, 3);
    }

    @Test
    public void case4() {
        assert 2 == getSum(0, 2);
    }

    @Test
    public void case5() {
        assert -2 == getSum(0, -2);
    }

    @Test
    public void case6() {
        assert -3 == getSum(-1, -2);
    }

    public int getSum(int a, int b) {
        int sum = a;
        int carry = b;
        do {
            int tmp = sum ^ carry;
            carry = (sum & carry) << 1;
            sum = tmp;
        } while (carry != 0);
        return sum;
    }
}

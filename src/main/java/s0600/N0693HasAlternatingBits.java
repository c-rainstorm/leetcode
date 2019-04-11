package s0600;

import org.junit.Test;

/**
 * [693] 交替位二进制数
 * <p>
 * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/description/
 * <p>
 * algorithms
 * Easy (59.19%)
 * Total Accepted:    5.2K
 * Total Submissions: 8.7K
 * Testcase Example:  '5'
 * <p>
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 * <p>
 * <p>
 * 示例 4:
 * <p>
 * <p>
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 *
 * @author baochen1.zhang
 * @date 2019.04.11
 */
public class N0693HasAlternatingBits {
    @Test
    public void case1() {
        assert hasAlternatingBits(5);
    }

    @Test
    public void case2() {
        assert !hasAlternatingBits(7);
    }

    @Test
    public void case3() {
        assert !hasAlternatingBits(11);
    }

    @Test
    public void case4() {
        assert hasAlternatingBits(10);
    }

    @Test
    public void case5() {
        assert !hasAlternatingBits(4);
    }


    public boolean hasAlternatingBits(int n) {
        int target = n;
        int mask = target & 1;
        while (target != 0) {
            target >>= 1;
            if ((mask ^ (target & 1)) == 0) {
                return false;
            }
            mask = target & 1;
        }
        return true;
    }
}

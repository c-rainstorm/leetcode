package s0000;

import org.junit.Test;

/**
 *
 * @lc app=leetcode.cn id=9 lang=java
 * <p>
 * [9] 回文数
 * <p>
 * https://leetcode-cn.com/problems/palindrome-number/description/
 * <p>
 * algorithms
 * Easy (56.07%)
 * Total Accepted:    90.7K
 * Total Submissions: 161.8K
 * Testcase Example:  '121'
 * <p>
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * <p>
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class N0009IsPalindrome {

    @Test
    public void case1() {
        assert isPalindrome(121);
    }

    @Test
    public void case2() {
        assert !isPalindrome(123);
    }

    @Test
    public void case3() {
        assert !isPalindrome(-121);
    }

    @Test
    public void case4() {
        assert !isPalindrome(10);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int source = x;
        int reverse = 0;
        while (source != 0) {
            // tmp 不可能为负数
            long tmp = reverse * 10L + source % 10;
            if (tmp >> 31 > 0) {
                return false;
            }

            reverse = (int) tmp;
            source /= 10;
        }
        return reverse == x;
    }
}

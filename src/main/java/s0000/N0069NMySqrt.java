package s0000;

import org.junit.Test;

/**
 * [69] x 的平方根
 *
 * https://leetcode-cn.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (35.18%)
 * Total Accepted:    29.6K
 * Total Submissions: 84.1K
 * Testcase Example:  '4'
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 *
 *
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 *
 * @author baochen1.zhang
 * @date 2019.04.05
 */
public class N0069NMySqrt {

    @Test
    public void case1(){
        assert 2 == mySqrt(4);
    }

    @Test
    public void case2(){
        assert 2 == mySqrt(8);
    }

    @Test
    public void case3(){
        assert 0 == mySqrt(0);
    }

    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }
}

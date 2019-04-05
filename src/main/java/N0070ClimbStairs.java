import org.junit.Test;

/**
 * [70] 爬楼梯
 * <p>
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 * <p>
 * algorithms
 * Easy (44.89%)
 * Total Accepted:    39.7K
 * Total Submissions: 88.5K
 * Testcase Example:  '2'
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @author baochen1.zhang
 * @date 2019.04.05
 */
public class N0070ClimbStairs {

    @Test
    public void case1() {
        assert climbStairs(1) == 1;
    }

    @Test
    public void case2() {
        assert climbStairs(2) == 2;
    }

    @Test
    public void case3() {
        assert climbStairs(3) == 3;
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int f1 = 1;
        int f2 = 2;
        for (int i = 2; i < n; ++i) {
            int tmp = f1 + f2;
            f1 = f2;
            f2 = tmp;
        }

        return f2;
    }
}

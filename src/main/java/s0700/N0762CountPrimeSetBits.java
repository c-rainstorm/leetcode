package s0700;

import me.rainstorm.util.BitUtil;
import org.junit.Test;

/**
 * [762] Prime Number of Set Bits in Binary Representation
 * <p>
 * https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/description/
 * <p>
 * algorithms
 * Easy (58.87%)
 * Total Accepted:    2.8K
 * Total Submissions: 4.7K
 * Testcase Example:  '842\n888'
 * <p>
 * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
 * <p>
 * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: L = 6, R = 10
 * 输出: 4
 * 解释:
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: L = 10, R = 15
 * 输出: 5
 * 解释:
 * 10 -> 1010 (2 个计算置位, 2 是质数)
 * 11 -> 1011 (3 个计算置位, 3 是质数)
 * 12 -> 1100 (2 个计算置位, 2 是质数)
 * 13 -> 1101 (3 个计算置位, 3 是质数)
 * 14 -> 1110 (3 个计算置位, 3 是质数)
 * 15 -> 1111 (4 个计算置位, 4 不是质数)
 * <p>
 * <p>
 * 注意:
 * <p>
 * <p>
 * L, R 是 L <= R 且在 [1, 10^6] 中的整数。
 * R - L 的最大值为 10000。
 *
 * @author baochen1.zhang
 * @date 2019.04.10
 */
public class N0762CountPrimeSetBits {

    @Test
    public void case1() {
        assert 4 == countPrimeSetBits(6, 10);
    }

    @Test
    public void case2() {
        assert 5 == countPrimeSetBits(10, 15);
    }

    @Test
    public void case3() {
        assert 23 == countPrimeSetBits(842, 888);
    }

    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = L; i <= R; ++i) {
            if (isPrime(BitUtil.countBit(i))) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int num) {
        return num == 2 || num == 3 || num == 5 || num == 7 || num == 11 || num == 13 ||
                num == 17 || num == 19 || num == 23 || num == 29 || num == 31;
    }
}

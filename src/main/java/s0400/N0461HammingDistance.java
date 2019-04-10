package s0400;

import me.rainstorm.util.BitUtil;
import org.junit.Test;

/**
 * [461] 汉明距离
 * <p>
 * https://leetcode-cn.com/problems/hamming-distance/description/
 * <p>
 * algorithms
 * Easy (68.63%)
 * Total Accepted:    16.2K
 * Total Submissions: 23.5K
 * Testcase Example:  '1\n4'
 * <p>
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 2^31.
 * <p>
 * 示例:
 * <p>
 * <p>
 * 输入: x = 1, y = 4
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ⁠      ↑   ↑
 * <p>
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * @author baochen1.zhang
 * @date 2019.04.10
 */
public class N0461HammingDistance {
    @Test
    public void case1() {
        assert 2 == hammingDistance(1, 4);
    }

    public int hammingDistance(int x, int y) {
        return BitUtil.countBit(x ^ y);
    }
}

package s0400;

import org.junit.Test;

/**
 * [476] 数字的补数
 * <p>
 * https://leetcode-cn.com/problems/number-complement/description/
 * <p>
 * algorithms
 * Easy (67.13%)
 * Total Accepted:    8.2K
 * Total Submissions: 12.2K
 * Testcase Example:  '5'
 * <p>
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * <p>
 * 注意:
 * <p>
 * <p>
 * 给定的整数保证在32位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: 5
 * 输出: 2
 * 解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: 1
 * 输出: 0
 * 解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。
 *
 * @author baochen1.zhang
 * @date 2019.04.10
 */
public class N0476FindComplement {

    @Test
    public void case1() {
        assert 2 == findComplement(5);
    }

    @Test
    public void case2() {
        assert 0 == findComplement(1);
    }

    public int findComplement(int num) {
        int mask = -1;
        while ((mask & num) != 0) {
            mask <<= 1;
        }
        return ~mask & ~num;
    }
}

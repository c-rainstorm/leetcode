import me.rainstorm.util.ArrayUtil;
import org.junit.Test;

/**
 * [66] 加一
 * <p>
 * https://leetcode-cn.com/problems/plus-one/description/
 * <p>
 * algorithms
 * Easy (38.05%)
 * Total Accepted:    44.5K
 * Total Submissions: 116.8K
 * Testcase Example:  '[1,2,3]'
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @author baochen1.zhang
 * @date 2019.04.03
 */
public class N0066PlusOne {
    @Test
    public void case1() {
        int[] result = plusOne(new int[]{4, 3, 2, 1});
        assert "4322".equals(ArrayUtil.buildStr(result, result.length));
    }

    @Test
    public void case2() {
        int[] result = plusOne(new int[]{1, 2, 3});
        assert "124".equals(ArrayUtil.buildStr(result, result.length));
    }

    @Test
    public void case3() {
        int[] result = plusOne(new int[]{9});
        assert "10".equals(ArrayUtil.buildStr(result, result.length));
    }

    @Test
    public void case4() {
        int[] result = plusOne(new int[]{9, 9, 9});
        assert "1000".equals(ArrayUtil.buildStr(result, result.length));
    }

    @Test
    public void case5() {
        int[] result = plusOne(new int[]{9, 8, 9});
        assert "990".equals(ArrayUtil.buildStr(result, result.length));
    }

    public int[] plusOne(int[] digits) {
        int index = digits.length;
        while (--index >= 0) {
            if (digits[index] == 9) {
                digits[index] = 0;
            } else {
                digits[index] += 1;
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        System.arraycopy(digits, 0, result, 1, digits.length);
        return result;
    }
}

package s0400;

import org.junit.Test;

/**
 * [405] 数字转换为十六进制数
 * <p>
 * https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/description/
 * <p>
 * algorithms
 * Easy (44.47%)
 * Total Accepted:    2.9K
 * Total Submissions: 6.4K
 * Testcase Example:  '26'
 * <p>
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * <p>
 * 注意:
 * <p>
 * <p>
 * 十六进制中所有字母(a-f)都必须是小写。
 * <p>
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入:
 * 26
 * <p>
 * 输出:
 * "1a"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入:
 * -1
 * <p>
 * 输出:
 * "ffffffff"
 *
 * @author baochen1.zhang
 * @date 2019.04.11
 */
public class N0405ToHex {
    @Test
    public void case1() {
        assert "1a".equals(toHex(26));
    }

    @Test
    public void case2() {
        assert "ffffffff".equals(toHex(-1));
    }

    @Test
    public void case3() {
        assert "0".equals(toHex(0));
    }

    public String toHex(int num) {
        String table = "0123456789abcdef";
        char[] result = new char[8];
        int target = num;
        int count = 8;
        while (count-- != 0) {
            result[count] = table.charAt(target & 0xf);
            target >>= 4;
        }
        int index = 0;
        while (index < 7 && result[index] == '0') {
            index++;
        }
        return new String(result, index, result.length - index);
    }
}

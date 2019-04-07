package s0000;

import org.junit.Test;

/**
 * [67] 二进制求和
 * <p>
 * https://leetcode-cn.com/problems/add-binary/description/
 * <p>
 * algorithms
 * Easy (47.29%)
 * Total Accepted:    20.4K
 * Total Submissions: 43.2K
 * Testcase Example:  '"11"\n"1"'
 * <p>
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * @author baochen1.zhang
 * @date 2019.04.04
 */
public class N0067AddBinary {
    @Test
    public void case1() {
        assert "100".equals(addBinary("11", "1"));
    }

    @Test
    public void case2() {
        assert "10101".equals(addBinary("1010", "1011"));
    }

    @Test
    public void case3() {
        assert "0".equals(addBinary("0", "0"));
    }

    public String addBinary(String a, String b) {
        int len = Math.max(a.length(), b.length()) + 1;
        StringBuilder builder = new StringBuilder(len);
        int overflow = 0;
        for (int i = 0; i < len; ++i) {
            int ai = getFromLast(a, i);
            int bi = getFromLast(b, i);
            int sum = ai + bi + overflow;
            builder.append(sum % 2);
            overflow = sum / 2;
        }
        int i = len - 1;
        while (i > 0 && builder.charAt(i) == '0') {
            i--;
        }
        builder.setLength(i + 1);
        return builder.reverse().toString();
    }

    private int getFromLast(String a, int i) {
        if (a.length() <= i) {
            return 0;
        }
        return a.charAt(a.length() - i - 1) - '0';
    }
}

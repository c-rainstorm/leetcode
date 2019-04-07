package s0000;

import org.junit.Test;

/**
 * [58] 最后一个单词的长度
 * <p>
 * https://leetcode-cn.com/problems/length-of-last-word/description/
 * <p>
 * algorithms
 * Easy (29.23%)
 * Total Accepted:    22.1K
 * Total Submissions: 75.6K
 * Testcase Example:  '"Hello World"'
 * <p>
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 *
 * @author baochen1.zhang
 * @date 2019.04.03
 */
public class N0058LengthOfLastWord {
    @Test
    public void case1() {
        assert lengthOfLastWord("    ") == 0;
    }

    @Test
    public void case2() {
        assert lengthOfLastWord("  xxx  ") == 3;
    }

    @Test
    public void case3() {
        assert lengthOfLastWord("  xxx") == 3;
    }

    @Test
    public void case4() {
        assert lengthOfLastWord("Hello World") == 5;
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (len != 0) {
                    return len;
                }
            } else {
                len++;
            }
        }

        return len;
    }
}

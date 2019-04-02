import org.junit.Test;

/**
 * @author baochen1.zhang
 * @lc app=leetcode.cn id=14 lang=java
 * <p>
 * [14] 最长公共前缀
 * <p>
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 * <p>
 * algorithms
 * Easy (32.53%)
 * Total Accepted:    65.3K
 * Total Submissions: 200.7K
 * Testcase Example:  '["flower","flow","flight"]'
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * @date 2019.04.02
 */
public class N0014LongestCommonPrefix {

    @Test
    public void case1() {
        String result = longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        assert "fl".equals(result);
    }

    @Test
    public void case2() {
        String result = longestCommonPrefix(new String[]{"dog", "racecar", "car"});
        assert "".equals(result);
    }

    @Test
    public void case3() {
        String result = longestCommonPrefix(new String[]{"ab", "ac"});
        assert "a".equals(result);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            if (minLen > str.length()) {
                minLen = str.length();
            }
        }

        for (int index = 0; index < minLen; ++index) {
            int ch = strs[0].charAt(index);
            for (int i = 1; i < strs.length; ++i) {
                if (ch != strs[i].charAt(index)) {
                    return strs[0].substring(0, index);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }
}

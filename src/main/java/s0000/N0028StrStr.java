package s0000;

import org.junit.Test;

/**
 * [28] 实现strStr()
 * <p>
 * https://leetcode-cn.com/problems/implement-strstr/description/
 * <p>
 * algorithms
 * Easy (37.98%)
 * Total Accepted:    44.7K
 * Total Submissions: 117.7K
 * Testcase Example:  '"hello"\n"ll"'
 * <p>
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * <p>
 * <p>
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * @author baochen1.zhang
 * @date 2019.04.03
 */
public class N0028StrStr {

    @Test
    public void case1() {
        assert strStr("hello", "ll") == 2;
    }

    @Test
    public void case2() {
        assert strStr("aaaaa", "bba") == -1;
    }

    @Test
    public void case3() {
        assert strStr("hello", "") == 0;
    }

    @Test
    public void case4() {
        assert strStr("", "") == 0;
    }

    @Test
    public void case5() {
        assert strStr("aa", "aaaa") == -1;
    }

    @Test
    public void case6() {
        assert strStr("a", "a") == 0;
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        if (needle.length() == 0) {
            return 0;
        } else if (haystack.length() == 0) {
            return -1;
        }
        int iLen = haystack.length() - needle.length() + 1;
        for (int i = 0; i < iLen; ++i) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean match = true;
                for (int j = 1; match && j < needle.length(); ++j) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        match = false;
                    }
                }
                if (match) {
                    return i;
                }
            }
        }
        return -1;
    }

}

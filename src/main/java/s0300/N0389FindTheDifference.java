package s0300;

import org.junit.Test;

/**
 * [389] 找不同
 * <p>
 * https://leetcode-cn.com/problems/find-the-difference/description/
 * <p>
 * algorithms
 * Easy (54.86%)
 * Total Accepted:    7.9K
 * Total Submissions: 14.3K
 * Testcase Example:  '"abcd"\n"abcde"'
 * <p>
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * <p>
 * 输出：
 * e
 * <p>
 * 解释：
 * 'e' 是那个被添加的字母。
 *
 * @author baochen1.zhang
 * @date 2019.04.11
 */
public class N0389FindTheDifference {
    @Test
    public void case1() {
        assert 'e' == findTheDifference("abcd", "abcde");
    }

    public char findTheDifference(String s, String t) {
        int result = 0;
        for(int i = 0; i < s.length(); ++i){
            result ^= s.charAt(i);
        }
        for(int i = 0; i < t.length(); ++i){
            result ^= t.charAt(i);
        }
        return (char) result;
    }
}

package s0700;

import org.junit.Test;

import java.util.HashSet;

/**
 * [771] Jewels and Stones
 * <p>
 * https://leetcode-cn.com/problems/jewels-and-stones/description/
 * <p>
 * algorithms
 * Easy (79.02%)
 * Total Accepted:    32.1K
 * Total Submissions: 40.5K
 * Testcase Example:  '"aA"\n"aAAbbbb"'
 * <p>
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * <p>
 * <p>
 * 注意:
 * <p>
 * <p>
 * S 和 J 最多含有50个字母。
 * J 中的字符不重复。
 *
 * @author baochen1.zhang
 * @date 2019.04.16
 */
public class N0771NumJewelsInStones {
    @Test
    public void case1() {
        assert 3 == numJewelsInStones("aA", "aAAbbbb");
    }

    @Test
    public void case2() {
        assert 0 == numJewelsInStones("z", "ZZ");
    }

    public int numJewelsInStones(String J, String S) {
        HashSet<Character> jewels = new HashSet<>();
        if (J == null || S == null) {
            return 0;
        }
        J.chars().forEach(e -> {
            jewels.add((char) e);
        });

        int count = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (jewels.contains(S.charAt(i))) {
                count++;
            }
        }

        return count;
    }
}

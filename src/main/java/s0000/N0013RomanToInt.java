package s0000;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author baochen1.zhang
 * @lc app=leetcode.cn id=13 lang=java
 * <p>
 * [13] 罗马数字转整数
 * <p>
 * https://leetcode-cn.com/problems/roman-to-integer/description/
 * <p>
 * algorithms
 * Easy (57.33%)
 * Total Accepted:    51.1K
 * Total Submissions: 89.1K
 * Testcase Example:  '"III"'
 * <p>
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V +
 * II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数
 * 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * <p>
 * <p>
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * <p>
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * <p>
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * <p>
 * <p>
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * @date 2019.04.02
 */
public class N0013RomanToInt {
    @Test
    public void case1() {
        int result = romanToInt("III");
        assert result == 3;
    }

    @Test
    public void case2() {
        int result = romanToInt("IV");
        assert result == 4;
    }

    @Test
    public void case3() {
        int result = romanToInt("IX");
        assert result == 9;
    }

    @Test
    public void case4() {
        int result = romanToInt("LVIII");
        assert result == 58;
    }

    @Test
    public void case5() {
        int result = romanToInt("MCMXCIV");
        assert result == 1994;
    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> charValueMap = new HashMap<>(7);
        charValueMap.put('I', 1);
        charValueMap.put('V', 5);
        charValueMap.put('X', 10);
        charValueMap.put('L', 50);
        charValueMap.put('C', 100);
        charValueMap.put('D', 500);
        charValueMap.put('M', 1000);

        int result = 0;
        int curMax = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            char ch = s.charAt(i);
            int value = charValueMap.get(ch);
            if (curMax <= value) {
                curMax = value;
                result += value;
            } else {
                result -= value;
            }
        }

        return result;
    }
}

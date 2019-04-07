package s0000;

import org.junit.Test;

import java.util.Stack;

/**
 * @author baochen1.zhang
 * @lc app=leetcode.cn id=20 lang=java
 * <p>
 * [20] 有效的括号
 * <p>
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 * <p>
 * algorithms
 * Easy (37.15%)
 * Total Accepted:    59.9K
 * Total Submissions: 161.1K
 * Testcase Example:  '"()"'
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * <p>
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * <p>
 * <p>
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * <p>
 * <p>
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * @date 2019.04.02
 */
public class N0020ValidParentheses {

    @Test
    public void case1() {
        assert isValid("()");
    }

    @Test
    public void case2() {
        assert isValid("()[]{}");
    }

    @Test
    public void case3() {
        assert !isValid("(]");
    }

    @Test
    public void case4() {
        assert !isValid("([)]");
    }

    @Test
    public void case5() {
        assert isValid("{[]}");
    }

    public void case6(){
        assert !isValid("]");
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> paras = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    paras.push(ch);
                    break;
                case ')':
                    if (dontMatch(paras, '(')) {
                        return false;
                    }
                    break;
                case ']':
                    if (dontMatch(paras, '[')) {
                        return false;
                    }
                    break;
                case '}':
                    if (dontMatch(paras, '{')) {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return paras.empty();
    }

    private boolean dontMatch(Stack<Character> paras, char c) {
        if (paras.empty()) {
            return true;
        }

        return paras.pop() != c;
    }
}

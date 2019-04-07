package contest.weekly131;

import org.junit.Test;

import java.util.Stack;

/**
 * @author baochen1.zhang
 * @date 2019.04.07
 */
public class N5016RemoveOuterParentheses {
    @Test
    public void case1() {
        assert "()()()".equals(removeOuterParentheses("(()())(())"));
    }

    @Test
    public void case2() {
        assert "()()()()(())".equals(removeOuterParentheses("(()())(())(()(()))"));
    }

    @Test
    public void case3() {
        assert "".equals(removeOuterParentheses("()()"));
    }

    public String removeOuterParentheses(String S) {
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); ++i) {
            char curCh = S.charAt(i);
            if (curCh == '(') {
                stack.push(curCh);
                if (stack.size() != 1) {
                    builder.append(curCh);
                }
            } else {
                stack.pop();
                if (!stack.empty()) {
                    builder.append(curCh);
                }
            }
        }
        return builder.toString();
    }
}

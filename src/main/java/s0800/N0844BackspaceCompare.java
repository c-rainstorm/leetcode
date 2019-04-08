package s0800;

import org.junit.Test;

import java.util.Stack;

/**
 * [844] Backspace String Compare
 * <p>
 * https://leetcode-cn.com/problems/backspace-string-compare/description/
 * <p>
 * algorithms
 * Easy (45.75%)
 * Total Accepted:    5K
 * Total Submissions: 11K
 * Testcase Example:  '"ab#c"\n"ad#c"'
 * <p>
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *
 * @author baochen1.zhang
 * @date 2019.04.08
 */
public class N0844BackspaceCompare {

    @Test
    public void case1() {
        assert backspaceCompare("ab#c", "ad#c");
    }

    @Test
    public void case2() {
        assert backspaceCompare("ab##", "c#d#");
    }

    @Test
    public void case3() {
        assert backspaceCompare("a##c", "#a#c");
    }

    @Test
    public void case4() {
        assert !backspaceCompare("a#c", "b");
    }


    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) {
            return false;
        }

        Stack<Character> stackS = getCharStack(S);
        Stack<Character> stackT = getCharStack(T);

        if (stackS.size() != stackT.size()) {
            return false;
        }
        while (!stackS.empty()) {
            if (stackS.peek().equals(stackT.peek())) {
                stackS.pop();
                stackT.pop();
            } else {
                break;
            }
        }

        return stackS.empty();
    }

    private Stack<Character> getCharStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (ch == '#') {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        return stack;
    }

}

package contest.weekly131;

import me.rainstorm.util.ArrayUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baochen1.zhang
 * @date 2019.04.07
 */
public class N5018CamelMatch {
    @Test
    public void case1() {
        assert "truefalsetruetruefalse".equals(ArrayUtil.toString(camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FB"), Integer.MAX_VALUE));
    }

    @Test
    public void case2() {
        assert "truefalsetruefalsefalse".equals(ArrayUtil.toString(camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBa"), Integer.MAX_VALUE));
    }

    @Test
    public void case3() {
        assert "falsetruefalsefalsefalse".equals(ArrayUtil.toString(camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBaT"), Integer.MAX_VALUE));
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>(queries.length);
        for (String query : queries) {
            int matched = 0;
            for (int i = 0; i < query.length(); ++i) {
                if (matched < pattern.length() && query.charAt(i) == pattern.charAt(matched)) {
                    matched++;
                } else if (Character.isUpperCase(query.charAt(i))) {
                    matched = 0;
                    break;
                }
            }
            result.add(matched == pattern.length());
        }
        return result;
    }
}

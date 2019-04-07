package s0100;

import me.rainstorm.util.ArrayUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * [119] 杨辉三角 II
 * <p>
 * https://leetcode-cn.com/problems/pascals-triangle-ii/description/
 * <p>
 * algorithms
 * Easy (54.33%)
 * Total Accepted:    12.1K
 * Total Submissions: 22.3K
 * Testcase Example:  '3'
 * <p>
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * @author baochen1.zhang
 * @date 2019.04.06
 */
public class N0119PascalsTriangleII {

    @Test
    public void case1() {
        List<Integer> result = getRow(1);
        assert "11".equals(ArrayUtil.toString(result, result.size()));
    }

    @Test
    public void case2() {
        List<Integer> result = getRow(2);
        assert "121".equals(ArrayUtil.toString(result, result.size()));
    }

    @Test
    public void case3() {
        List<Integer> result = getRow(3);
        assert "1331".equals(ArrayUtil.toString(result, result.size()));
    }

    @Test
    public void case4() {
        List<Integer> result = getRow(0);
        assert "1".equals(ArrayUtil.toString(result, result.size()));
    }

    @Test
    public void case5() {
        List<Integer> result = getRow(5);
        assert "15101051".equals(ArrayUtil.toString(result, result.size()));
    }

    public List<Integer> getRow(int rowIndex) {
        int rowNum = rowIndex + 1;
        Integer[] row = new Integer[rowNum];
        row[0] = 1;
        row[rowIndex] = 1;
        if (rowIndex < 2) {
            return Arrays.asList(row);
        }
        row[1] = 1;
        for (int i = 3; i <= rowNum; ++i) {
            row[i - 1] = 1;
            for (int j = i - 2; j > 0; --j) {
                row[j] += row[j - 1];
            }
        }
        return Arrays.asList(row);
    }
}

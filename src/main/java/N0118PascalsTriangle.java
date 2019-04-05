import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [118] 杨辉三角
 * <p>
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 * <p>
 * algorithms
 * Easy (60.84%)
 * Total Accepted:    19.7K
 * Total Submissions: 32.2K
 * Testcase Example:  '5'
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 *
 * @author baochen1.zhang
 * @date 2019.04.05
 */
public class N0118PascalsTriangle {

    @Test
    public void case1() {
        List<List<Integer>> result = generate(1);
        System.out.println(result);
    }

    @Test
    public void case2() {
        List<List<Integer>> result = generate(2);
        System.out.println(result);
    }

    @Test
    public void case3() {
        List<List<Integer>> result = generate(5);
        System.out.println(result);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>(numRows);
        if (numRows == 0) {
            return pascalsTriangle;
        }
        for (int i = 0; i < numRows; ++i) {
            pascalsTriangle.add(buildNextRow(pascalsTriangle, i));
        }
        return pascalsTriangle;
    }

    private List<Integer> buildNextRow(List<List<Integer>> pascalsTriangle, int i) {
        Integer[] row = new Integer[i + 1];
        row[0] = 1;
        row[i] = 1;
        if (i == 0) {
            return Arrays.asList(row);
        }
        List<Integer> preRow = pascalsTriangle.get(i - 1);
        for (int j = 1; j < i; ++j) {
            row[j] = preRow.get(j) + preRow.get(j - 1);
        }
        return Arrays.asList(row);
    }

}

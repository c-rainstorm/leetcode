import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * [167] 两数之和 II - 输入有序数组
 * <p>
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
 * <p>
 * algorithms
 * Easy (48.02%)
 * Total Accepted:    20.5K
 * Total Submissions: 42.8K
 * Testcase Example:  '[2,7,11,15]\n9'
 * <p>
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * @author baochen1.zhang
 * @date 2019.04.06
 */
public class N0167TwoSumII {

    @Test
    public void case1() {
        assert "[1, 2]".equals(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    @Test
    public void case2() {
        assert "[0, 0]".equals(Arrays.toString(twoSum(new int[]{2}, 9)));
    }

    @Test
    public void case3() {
        assert "[0, 0]".equals(Arrays.toString(twoSum(new int[]{2, 6}, 9)));
    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) {
            return new int[]{0, 0};
        }
        HashMap<Integer, Integer> cache = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; ++i) {
            if (cache.containsKey(numbers[i])) {
                return new int[]{cache.get(numbers[i]), i + 1};
            } else {
                cache.put(target - numbers[i], i + 1);
            }
        }
        return new int[]{0, 0};
    }
}

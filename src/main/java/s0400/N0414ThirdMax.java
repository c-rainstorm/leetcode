package s0400;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * [414] 第三大的数
 * <p>
 * https://leetcode-cn.com/problems/third-maximum-number/description/
 * <p>
 * algorithms
 * Easy (31.05%)
 * Total Accepted:    6.6K
 * Total Submissions: 21.2K
 * Testcase Example:  '[3,2,1]'
 * <p>
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: [3, 2, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 第三大的数是 1.
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: [1, 2]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: [2, 2, 3, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *
 * @author baochen1.zhang
 * @date 2019.04.07
 */
public class N0414ThirdMax {
    @Test
    public void case1() {
        assert 1 == thirdMax(new int[]{3, 2, 1});
    }

    @Test
    public void case2() {
        assert 1 == thirdMax(new int[]{3, 2, 2, 1});
    }

    @Test
    public void case3() {
        assert 2 == thirdMax(new int[]{1, 2});
    }

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = nums.length - 1; i >= 0 && map.size() != 3; --i) {
            map.put(nums[i], i);
        }
        if (map.size() < 3) {
            return nums[nums.length - 1];
        } else {
            return nums[map.values().toArray(new Integer[0])[2]];
        }
    }
}

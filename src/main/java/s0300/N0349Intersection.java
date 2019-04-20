package s0300;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * [349] 两个数组的交集
 * <p>
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
 * <p>
 * algorithms
 * Easy (61.13%)
 * Total Accepted:    18.1K
 * Total Submissions: 29.3K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * <p>
 * 说明:
 * <p>
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * @author baochen1.zhang
 * @date 2019.04.20
 */
public class N0349Intersection {

    @Test
    public void case1() {
        assert "[2]".equals(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }

    @Test
    public void case2() {
        int[] result = intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        Arrays.sort(result);
        assert "[4, 9]".equals(Arrays.toString(result));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(nums1.length);
        Arrays.sort(nums1);
        for (int value : nums2) {
            if (Arrays.binarySearch(nums1, value) >= 0) {
                set.add(value);
            }
        }

        int[] result = new int[set.size()];
        int count = 0;
        for (Integer integer : set) {
            result[count++] = integer;
        }

        return result;
    }
}

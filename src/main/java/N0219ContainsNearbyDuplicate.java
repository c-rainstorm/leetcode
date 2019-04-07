import org.junit.Test;

import java.util.HashMap;

/**
 * [219] 存在重复元素 II
 * <p>
 * https://leetcode-cn.com/problems/contains-duplicate-ii/description/
 * <p>
 * algorithms
 * Easy (33.87%)
 * Total Accepted:    11.1K
 * Total Submissions: 33K
 * Testcase Example:  '[1,2,3,1]\n3'
 * <p>
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j
 * 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * <p>
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * @author baochen1.zhang
 * @date 2019.04.07
 */
public class N0219ContainsNearbyDuplicate {
    @Test
    public void case1() {
        assert containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3);
    }

    @Test
    public void case2() {
        assert containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1);
    }

    @Test
    public void case3() {
        assert !containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) + k >= i) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}

package s0100;

import org.junit.Test;

import java.util.HashMap;

/**
 * [169] 求众数
 * <p>
 * https://leetcode-cn.com/problems/majority-element/description/
 * <p>
 * algorithms
 * Easy (58.42%)
 * Total Accepted:    33.3K
 * Total Submissions: 57K
 * Testcase Example:  '[3,2,3]'
 * <p>
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @author baochen1.zhang
 * @date 2019.04.06
 */
public class N0169MajorityElement {
    @Test
    public void case1() {
        assert 3 == majorityElement(new int[]{3, 2, 3});
    }

    @Test
    public void case2() {
        assert 2 == majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
    }


    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        HashMap<Integer, Integer> countMap = new HashMap<>(nums.length / 2);
        int threshold = nums.length / 2;
        for (int i = 0; i < nums.length; ++i) {
            if (countMap.containsKey(nums[i])) {
                Integer newCount = countMap.get(nums[i]) + 1;
                if (newCount > threshold) {
                    return nums[i];
                } else {
                    countMap.put(nums[i], newCount);
                }
            } else {
                countMap.put(nums[i], 1);
            }
        }
        return 0;
    }
}

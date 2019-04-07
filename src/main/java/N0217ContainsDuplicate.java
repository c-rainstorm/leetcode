import org.junit.Test;

import java.util.HashSet;

/**
 * [217] 存在重复元素
 * <p>
 * https://leetcode-cn.com/problems/contains-duplicate/description/
 * <p>
 * algorithms
 * Easy (47.56%)
 * Total Accepted:    49.9K
 * Total Submissions: 104.7K
 * Testcase Example:  '[1,2,3,1]'
 * <p>
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * <p>
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * @author baochen1.zhang
 * @date 2019.04.07
 */
public class N0217ContainsDuplicate {
    @Test
    public void case1() {
        assert containsDuplicate(new int[]{1, 2, 3, 1});
    }

    @Test
    public void case2() {
        assert !containsDuplicate(new int[]{1, 2, 3, 4});
    }

    @Test
    public void case3() {
        assert containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2});
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> map = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            if (map.contains(nums[i])) {
                return true;
            } else {
                map.add(nums[i]);
            }
        }
        return false;
    }
}

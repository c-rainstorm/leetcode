import me.rainstorm.util.ArrayUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * [448] 找到所有数组中消失的数字
 * <p>
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/description/
 * <p>
 * algorithms
 * Easy (46.81%)
 * Total Accepted:    6.2K
 * Total Submissions: 13.1K
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 * <p>
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 *
 * @author baochen1.zhang
 * @date 2019.04.07
 */
public class N0448FindDisappearedNumbers {

    @Test
    public void case1() {
        assert "56".equals(ArrayUtil.toString(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}), Integer.MAX_VALUE));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int start = 0; start < nums.length; ++start) {
            for (int index = start, value = nums[index]; index + 1 != nums[index]; ) {
                int tmp = nums[value - 1];
                nums[value - 1] = value;
                index = tmp - 1;
                value = tmp;
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }
}

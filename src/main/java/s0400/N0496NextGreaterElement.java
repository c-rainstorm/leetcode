package s0400;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * [496] 下一个更大元素 I
 * <p>
 * https://leetcode-cn.com/problems/next-greater-element-i/description/
 * <p>
 * algorithms
 * Easy (57.86%)
 * Total Accepted:    6.9K
 * Total Submissions: 11.9K
 * Testcase Example:  '[4,1,2]\n[1,3,4,2]'
 * <p>
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2
 * 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * ⁠   对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * ⁠   对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * ⁠   对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 * 对于num1中的数字2，第二个数组中的下一个较大数字是3。
 * ⁠   对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 * <p>
 * <p>
 * 注意:
 * <p>
 * <p>
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 *
 * @author baochen1.zhang
 * @date 2019.04.08
 */
public class N0496NextGreaterElement {

    @Test
    public void case0() {
        assert "[]".equals(Arrays.toString(nextGreaterElement(new int[]{}, new int[]{})));
    }

    @Test
    public void case1() {
        assert "[3, -1]".equals(Arrays.toString(nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }

    @Test
    public void case2() {
        assert "[-1, 3, -1]".equals(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        if (nums1.length == 0 || nums2.length == 0) {
            return result;
        }
        HashMap<Integer, Integer> indexMap = new HashMap<>(nums2.length);
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; ++i) {
            while (!stack.empty()) {
                if (stack.peek() >= nums2[i]) {
                    stack.push(nums2[i]);
                    break;
                } else {
                    indexMap.put(stack.pop(), nums2[i]);
                }
            }
            stack.push(nums2[i]);
        }
        while (!stack.empty()) {
            indexMap.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; ++i) {
            result[i] = indexMap.get(nums1[i]);
        }

        return result;
    }
}

package s0200;

import org.junit.Test;

import java.util.PriorityQueue;

import static me.rainstorm.util.SortUtil.partition;

/**
 * [215] 数组中的第K个最大元素
 * <p>
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 * <p>
 * algorithms
 * Medium (56.47%)
 * Total Accepted:    22.3K
 * Total Submissions: 39.4K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * @author baochen1.zhang
 * @date 2019.04.22
 */
public class N0215FindKthLargest {
    @Test
    public void case1() {
        assert 5 == findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }

    @Test
    public void case2() {
        assert 4 == findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
    }

    @Test
    public void case3() {
        assert 3 == findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 5);
    }

    @Test
    public void case4() {
        assert 1 == findKthLargest(new int[]{1}, 1);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> -o1.compareTo(o2));
        for (int num : nums) {
            priorityQueue.add(num);
        }

        int result = 0;
        int kth = k;
        while (kth-- != 0) {
            result = priorityQueue.poll();
        }
        return result;
    }

    public int findKthLargest0(int[] nums, int k) {
        return findKthLargest0(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private int findKthLargest0(int[] nums, int start, int end, int k) {
        int i = partition(nums, start, end);
        if (i < k - 1) {
            return findKthLargest0(nums, i + 1, end, k);
        } else if (i > k - 1) {
            return findKthLargest0(nums, start, i - 1, k);
        } else {
            return nums[i];
        }
    }
}

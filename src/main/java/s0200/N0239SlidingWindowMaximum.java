package s0200;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/
 *
 * @author traceless
 */
public class N0239SlidingWindowMaximum {

    /**
     * 基于最大堆的解法
     * 时间复杂度 O(n * log(n))
     * 空间复杂度 O(n)
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((numIndexPair1, numIndexPair2)
                -> numIndexPair1[0] != numIndexPair2[0] ?
                numIndexPair2[0] - numIndexPair1[0] :
                numIndexPair2[1] - numIndexPair1[1]);

        int[] ans = new int[nums.length - k + 1];
        for (int i = 0, ansIndex; i < nums.length; ++i) {
            ansIndex = Math.max(i - k + 1, 0);

            maxHeap.offer(new int[]{nums[i], i});
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }
            ans[ansIndex] = maxHeap.peek()[0];
        }

        return ans;
    }

    /**
     * 基于双端队列
     * 队列中存的是下标，根据下标，查到的原始值则是单调递减的
     * 时间复杂度 O(n)
     * 空间复杂度 O(k)
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> indexDeque = new LinkedList<>();

        int[] ans = new int[nums.length - k + 1];
        for (int i = 0, ansIndex; i < nums.length; ++i) {
            ansIndex = Math.max(i - k + 1, 0);

            while (!indexDeque.isEmpty() && nums[i] >= nums[indexDeque.peekLast()]) {
                indexDeque.pollLast();
            }
            indexDeque.offerLast(i);
            while (indexDeque.peekFirst() <= i - k) {
                indexDeque.pollFirst();
            }
            ans[ansIndex] = nums[indexDeque.peekFirst()];
        }
        return ans;
    }
}

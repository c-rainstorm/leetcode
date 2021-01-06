package s0000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/solution/pai-xu-shuang-zhi-zhen-zhu-xing-jie-shi-python3-by/
 *
 * @author traceless
 */
public class N0015ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target = 0;

        List<List<Integer>> lists = new LinkedList<>();
        for (int first = 0; first < nums.length; ++first) {
            if (nums[first] > 0) break;
            if (first > 0 && nums[first - 1] == nums[first]) continue;

            int second = first + 1, third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum < target) {
                    ++second;
                } else if (sum > target) {
                    --third;
                } else {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    lists.add(list);
                    ++second;
                    --third;
                    while (second < third && nums[second - 1] == nums[second]) ++second;
                    while (second < third && nums[third + 1] == nums[third]) --third;
                }
            }

        }
        return lists;
    }
}

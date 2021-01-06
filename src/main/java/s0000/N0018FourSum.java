package s0000;

import java.util.*;

public class N0018FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4)
            return Collections.emptyList();

        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        for (int first = 0; first < nums.length - 3; ++first) {
            if (first > 0 && nums[first - 1] == nums[first]) continue;

            for (int second = first + 1; second < nums.length - 2; ++second) {
                if (second > first + 1 && nums[second - 1] == nums[second]) continue;

                int third = second + 1, fourth = nums.length - 1;
                while (third < fourth) {
                    int sum = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (sum < target) {
                        ++third;
                    } else if (sum > target) {
                        --fourth;
                    } else {
                        List<Integer> list = new ArrayList<>(4);
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[fourth]);
                        lists.add(list);
                        ++third;
                        --fourth;
                        while (third < fourth && nums[third - 1] == nums[third]) ++third;
                        while (third < fourth && nums[fourth + 1] == nums[fourth]) --fourth;
                    }
                }
            }
        }
        return lists;
    }
}

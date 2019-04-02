import org.junit.Test;

/**
 * @author baochen1.zhang
 * @date 2019.04.02
 * @lc app=leetcode.cn id=26 lang=java
 * <p>
 * [26] 删除排序数组中的重复项
 * <p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
 * <p>
 * algorithms
 * Easy (43.43%)
 * Total Accepted:    100.7K
 * Total Submissions: 231.6K
 * Testcase Example:  '[1,1,2]'
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 */
public class N0026RemoveDuplicates {

    @Test
    public void case1() {
        int[] nums = new int[]{1, 1, 2};
        int len = removeDuplicates(nums);
        assert len == 2;
        assert "12".equals(buildStr(nums, len));
    }

    @Test
    public void case2() {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicates(nums);
        assert len == 5;
        assert "01234".equals(buildStr(nums, len));
    }

    @Test
    public void case3() {
        int[] nums = new int[]{};
        int len = removeDuplicates(nums);
        assert len == 0;
        assert "".equals(buildStr(nums, len));
    }

    @Test
    public void case4() {
        int[] nums = new int[]{1, 2};
        int len = removeDuplicates(nums);
        assert len == 2;
        assert "12".equals(buildStr(nums, len));
    }

    @Test
    public void case5() {
        int[] nums = new int[]{1, 1};
        int len = removeDuplicates(nums);
        assert len == 1;
        assert "1".equals(buildStr(nums, len));
    }

    private String buildStr(int[] nums, int len) {
        StringBuilder builder = new StringBuilder();
        int length = Math.min(nums.length, len);
        for (int i = 0; i < length; ++i) {
            builder.append(nums[i]);
        }
        return builder.toString();
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int x = 1;
        int j = 1;
        while (j < nums.length) {
            if (nums[j - 1] == nums[j]) {
                j++;
            } else {
                nums[x++] = nums[j++];
            }
        }

        return x;
    }
}

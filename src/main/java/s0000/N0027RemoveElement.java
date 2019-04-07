package s0000;

import org.junit.Test;

import static me.rainstorm.util.ArrayUtil.buildStr;

/**
 * [27] 移除元素
 * <p>
 * https://leetcode-cn.com/problems/remove-element/description/
 * <p>
 * algorithms
 * Easy (54.00%)
 * Total Accepted:    46.7K
 * Total Submissions: 86.3K
 * Testcase Example:  '[3,2,2,3]\n3'
 * <p>
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
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
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 *
 * @author baochen1.zhang
 * @date 2019.04.03
 */
public class N0027RemoveElement {

    @Test
    public void case1() {
        int[] nums = new int[]{1, 1, 2};
        int len = removeElement(nums, 2);
        assert len == 2;
        assert "11".equals(buildStr(nums, len));
    }

    @Test
    public void case2() {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeElement(nums, 1);
        assert len == 7;
        assert "0022334".equals(buildStr(nums, len));
    }

    @Test
    public void case3() {
        int[] nums = new int[]{};
        int len = removeElement(nums, 1);
        assert len == 0;
        assert "".equals(buildStr(nums, len));
    }

    @Test
    public void case4() {
        int[] nums = new int[]{1, 2};
        int len = removeElement(nums, 1);
        assert len == 1;
        assert "2".equals(buildStr(nums, len));
    }

    @Test
    public void case5() {
        int[] nums = new int[]{1, 1};
        int len = removeElement(nums, 1);
        assert len == 0;
        assert "".equals(buildStr(nums, len));
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int x = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] == val) {
                j++;
            } else {
                nums[x++] = nums[j++];
            }
        }

        return x;
    }
}

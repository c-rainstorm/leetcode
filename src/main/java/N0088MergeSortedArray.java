import me.rainstorm.util.ArrayUtil;
import org.junit.Test;

/**
 * [88] 合并两个有序数组
 * <p>
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 * <p>
 * algorithms
 * Easy (43.42%)
 * Total Accepted:    37.3K
 * Total Submissions: 85.6K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 *
 * @author baochen1.zhang
 * @date 2019.04.05
 */
public class N0088MergeSortedArray {

    @Test
    public void case1() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        assert "122356".equals(ArrayUtil.buildStr(nums1, 6));
    }

    @Test
    public void case2() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{-1, 0, 1};
        merge(nums1, 3, nums2, 3);
        assert "-101123".equals(ArrayUtil.buildStr(nums1, 6));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        int index1 = m - 1;
        int index2 = n - 1;
        while (index1 >= 0 && index2 >= 0 && i >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[i--] = nums1[index1--];
            } else {
                nums1[i--] = nums2[index2--];
            }
        }
        while (index1 < 0 && index2 >= 0) {
            nums1[i--] = nums2[index2--];
        }
    }
}

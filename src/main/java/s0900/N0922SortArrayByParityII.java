package s0900;

import org.junit.Test;

/**
 * [922] 按奇偶排序数组
 * <p>
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/description/
 * <p>
 * algorithms
 * Easy (66.27%)
 * Total Accepted:    9.3K
 * Total Submissions: 14.3K
 * Testcase Example:  '[4,2,5,7]'
 * <p>
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * @author baochen1.zhang
 * @date 2019.04.19
 */
public class N0922SortArrayByParityII {

    @Test
    public void case1() {
        int[] result = sortArrayByParityII(new int[]{4, 2, 5, 7});
        assert isSorted(result);
    }

    @Test
    public void case2() {
        int[] result = sortArrayByParityII(new int[]{4, 1, 1, 0, 1, 0});
        assert isSorted(result);
    }

    private boolean isSorted(int[] result) {
        for (int i = 0; i < result.length; ++i) {
            if (((i & 1) ^ (result[i] & 1)) == 1) {
                return false;
            }
        }
        return true;
    }

    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;
        for (; i < A.length; i += 2) {
            if (((i & 1) ^ (A[i] & 1)) == 0) {
                continue;
            }
            for (; j < A.length; j += 2) {
                if (((j & 1) ^ (A[j] & 1)) == 1) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    break;
                }
            }
        }
        return A;
    }
}

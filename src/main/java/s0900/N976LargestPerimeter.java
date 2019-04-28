package s0900;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * <p>
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1,2]
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：[1,2,1]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：[3,2,3,4]
 * 输出：10
 * 示例 4：
 * <p>
 * 输入：[3,6,2,3]
 * 输出：8
 *
 * @author baochen1.zhang
 * @date 2019.04.28
 */
public class N976LargestPerimeter {

    @Test
    public void case1() {
        assert 5 == largestPerimeter(new int[]{2, 1, 2});
    }

    @Test
    public void case2() {
        assert 0 == largestPerimeter(new int[]{1, 2, 1});
    }

    @Test
    public void case3() {
        assert 10 == largestPerimeter(new int[]{3, 2, 3, 4});
    }

    @Test
    public void case4() {
        assert 8 == largestPerimeter(new int[]{3, 6, 2, 3});
    }

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);

        int result = 0;
        for (int i = A.length - 1; i >= 2; i--) {
            result = judge(A, i, i - 1, i - 2);
            if (result != 0) {
                break;
            }
        }

        return result;
    }

    private int judge(int[] a, int i, int j, int k) {
        if (a[j] + a[k] <= a[i]) {
            return 0;
        }
        if (a[i] - a[j] >= a[k]) {
            return 0;
        }

        return a[i] + a[j] + a[k];
    }
}

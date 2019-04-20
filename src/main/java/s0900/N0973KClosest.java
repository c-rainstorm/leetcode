package s0900;

import org.junit.Test;

import java.util.Arrays;

/**
 * [973] 最接近原点的 K 个点
 * <p>
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/description/
 * <p>
 * algorithms
 * Medium (62.96%)
 * Total Accepted:    3K
 * Total Submissions: 4.9K
 * Testcase Example:  '[[1,3],[-2,2]]\n1'
 * <p>
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * <p>
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * <p>
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 * @author baochen1.zhang
 * @date 2019.04.20
 */
public class N0973KClosest {

    @Test
    public void case1() {
        int k = 1;
        int[][] result = kClosest(new int[][]{
                {1, 3},
                {-2, 2}}, k);
        assert result.length == k;
        assert "[-2, 2]".equals(Arrays.toString(result[0]));
    }

    @Test
    public void case2() {
        int k = 2;
        int[][] result = kClosest(new int[][]{
                {3, 3},
                {5, -1},
                {-2, 4}}, k);
        assert result.length == k;
        assert "[3, 3]".equals(Arrays.toString(result[0]));
        assert "[-2, 4]".equals(Arrays.toString(result[1]));
    }

    /**
     * 更好的解法：
     * 1. 计算每个 point 的距离
     * 2. 距离排序，找到第 k 个距离
     * 3. 遍历 points 找到所有距离小于等于第 k 个距离的点
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        double[] sqrts = new double[K];
        int[] indexs = new int[K];
        int count = 0;
        for (int i = 0; i < points.length; ++i) {
            count = addToArray(points, i, sqrts, indexs, count);
        }

        int[][] result = new int[K][];
        for (int i = 0; i < count; ++i) {
            result[i] = points[indexs[i]];
        }

        return result;
    }

    private int addToArray(int[][] points, int i, double[] sqrts, int[] indexs, int count) {
        int[] point = points[i];
        double sqrt = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
        int j = count;

        for (; j > 0; --j) {
            if (sqrts[j - 1] > sqrt) {
                if (j < sqrts.length) {
                    sqrts[j] = sqrts[j - 1];
                    indexs[j] = indexs[j - 1];
                }
            } else {
                break;
            }
        }
        if (j < sqrts.length) {
            sqrts[j] = sqrt;
            indexs[j] = i;
        }

        return Math.min(count + 1, sqrts.length);
    }
}

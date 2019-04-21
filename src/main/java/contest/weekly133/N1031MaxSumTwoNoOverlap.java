package contest.weekly133;

import org.junit.Test;

/**
 * @author baochen1.zhang
 * @date 2019.04.21
 */
public class N1031MaxSumTwoNoOverlap {
    @Test
    public void case1() {
        assert 20 == maxSumTwoNoOverlap(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2);
    }


    @Test
    public void case2() {
        assert 29 == maxSumTwoNoOverlap(new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0}, 3, 2);
    }

    @Test
    public void case3() {
        assert 31 == maxSumTwoNoOverlap(new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3);
    }

    @Test
    public void case4() {
        assert 108 == maxSumTwoNoOverlap(new int[]{8, 20, 6, 2, 20, 17, 6, 3, 20, 8, 12}, 5, 4);
    }

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        Sum[] lsum = buildSum(A, L);
        Sum[] msum = buildSum(A, M);

        return findMaxSum(lsum, L, msum, M);
    }

    private int findMaxSum(Sum[] lsums, int l, Sum[] msums, int m) {
        int max = 0;

        for (Sum lsum : lsums) {
            for (Sum msum : msums) {
                if (lsum.index >= msum.index + m || lsum.index + l <= msum.index) {
                    max = Math.max(max, lsum.sum + msum.sum);
                }
            }
        }

        return max;
    }

    private Sum[] buildSum(int[] a, int l) {
        Sum[] sum = new Sum[a.length - l + 1];
        for (int i = 0; i + l <= a.length; ++i) {
            sum[i] = new Sum();
            sum[i].index = i;
            for (int j = 0; j < l; ++j) {
                sum[i].sum += a[i + j];
            }
        }

        return sum;
    }

    class Sum implements Comparable<Sum> {
        int sum;
        int index;

        @Override
        public int compareTo(Sum o) {
            return Integer.signum(o.sum - this.sum);
        }
    }
}

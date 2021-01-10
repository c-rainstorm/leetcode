package s0000;

/**
 * @author traceless
 */
public class N0053MaximumSubarray {
    public static class Result {
        public int aSum, lSum, rSum, mSum;

        public Result(int aSum, int lSum, int rSum, int mSum) {
            this.aSum = aSum;
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
        }

        public Result(Result l, Result r) {
            aSum = l.aSum + r.aSum;
            lSum = Math.max(l.lSum, l.aSum + r.lSum);
            rSum = Math.max(r.rSum, r.aSum + l.rSum);
            mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        }
    }

    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1).mSum;
    }

    public Result maxSubArray(int[] a, int lo, int hi) {
        if (lo == hi) {
            return new Result(a[lo], a[lo], a[lo], a[lo]);
        }
        int mid = (lo + hi) >> 1;
        Result l = maxSubArray(a, lo, mid);
        Result r = maxSubArray(a, mid + 1, hi);
        return new Result(l, r);
    }
}

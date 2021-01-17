package s0100;

/**
 * @author traceless
 */
public class N0152MaximumProductSubarray {

    /**
     * dp[i] : 含有元素 i 的最大乘积子序和
     */
    public int maxProduct1(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        int[] dpMax = new int[length];
        int[] dpMin = new int[length];
        dpMax[0] = dpMin[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(dpMin[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(dpMax[i - 1] * nums[i], nums[i]));
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }

    public int maxProduct2(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        int[][] dp = new int[length][2];
        dp[0][0] = dp[0][1] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] * nums[i], Math.max(dp[i - 1][1] * nums[i], nums[i]));
            dp[i][1] = Math.min(dp[i - 1][0] * nums[i], Math.min(dp[i - 1][1] * nums[i], nums[i]));
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }

    public int maxProduct(int[] nums) {
        int max;
        int[][] dp = new int[2][2];
        dp[0][0] = dp[0][1] = max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = (i & 1), y = (1 - x);
            dp[x][0] = Math.max(dp[y][0] * nums[i], Math.max(dp[y][1] * nums[i], nums[i]));
            dp[x][1] = Math.min(dp[y][0] * nums[i], Math.min(dp[y][1] * nums[i], nums[i]));
            max = Math.max(max, dp[x][0]);
        }
        return max;
    }
}

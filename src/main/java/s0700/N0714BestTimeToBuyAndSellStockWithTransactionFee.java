package s0700;

/**
 * @author traceless
 */
public class N0714BestTimeToBuyAndSellStockWithTransactionFee {

    /**
     * 解法一
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i] - fee)
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
     */
    public int maxProfitS(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + (prices[i] - fee));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    /**
     * 解法二，简化解法一
     */
    public int maxProfitSS(int[] prices, int fee) {
        int[] dp = new int[2];
        dp[1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int dp00 = dp[0];
            dp[0] = Math.max(dp00, dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], dp00 - prices[i]);
        }
        return dp[0];
    }

    /**
     * 解法三，简化解法二
     */
    public int maxProfitSSS(int[] prices, int fee) {
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int dp00 = dp0;
            dp0 = Math.max(dp00, dp1 + prices[i] - fee);
            dp1 = Math.max(dp1, dp00 - prices[i]);
        }
        return dp0;
    }
}

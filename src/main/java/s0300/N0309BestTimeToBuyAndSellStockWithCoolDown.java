package s0300;

/**
 * @author traceless
 */
public class N0309BestTimeToBuyAndSellStockWithCoolDown {
    /**
     * 方案一，普通动态规划
     * <p>
     * dp[i][0] = max(dp[i-1][0], dp[i-1][2])           // 前一天不持股，前一天是冻结期
     * <p>
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0]-price[i])  // 前一天持股，前一天不持股，今天买入
     * <p>
     * dp[i][2] = dp[i-1][1] + price[i]                 // 前一天卖出，今天为冻结期
     * <p>
     * ans = max(dp[n-1][0], dp[n-1][2])                // 不持股或冻结期
     *
     * // 持股 -卖出-> 冻结期 --> 不持股
     * //  ^--------买入-----------|
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[][] dp = new int[prices.length][3];
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }

    /**
     * 方案二：简化方案一
     */
    public int maxProfitSS(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[] dp = new int[3];
        dp[1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int dp00 = dp[0];
            int dp01 = dp[1];
            dp[0] = Math.max(dp00, dp[2]);
            dp[1] = Math.max(dp00 - prices[i], dp[1]);
            dp[2] = dp01 + prices[i];
        }
        return Math.max(dp[0], dp[2]);
    }

    /**
     * 方案三：简化方案二
     */
    public int maxProfitSSS(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int dp0 = 0, dp1 = -prices[0], dp2 = 0;
        for (int i = 1; i < prices.length; i++) {
            int dp00 = dp0;
            int dp01 = dp1;
            dp0 = Math.max(dp00, dp2);
            dp1 = Math.max(dp00 - prices[i], dp1);
            dp2 = dp01 + prices[i];
        }
        return Math.max(dp0, dp2);
    }
}

package s0100;

/**
 * @author traceless
 */
public class N0112BestTimeToBuyAndSellStockII {

    /**
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
     */
    public int maxProfit(int[] price) {
        if (price == null || price.length <= 1) return 0;
        int[][] dp = new int[price.length][2];
        dp[0][1] = -price[0];
        for (int i = 1; i < price.length; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + price[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - price[i]);
        }
        return dp[price.length - 1][0];
    }

    public int maxProfitSS(int[] price) {
        if (price == null || price.length <= 1) return 0;
        int[] dp = new int[2];
        dp[1] = -price[0];
        for (int i = 1; i < price.length; ++i) {
            int dp00 = dp[0];
            dp[0] = Math.max(dp00, dp[1] + price[i]);
            dp[1] = Math.max(dp[1], dp00 - price[i]);
        }
        return dp[0];
    }

    public int maxProfitSSS(int[] price) {
        if (price == null || price.length <= 1) return 0;
        int dp0 = 0, dp1 = -price[0];
        for (int i = 1; i < price.length; ++i) {
            int dp00 = dp0;
            dp0 = Math.max(dp00, dp1 + price[i]);
            dp1 = Math.max(dp1, dp00 - price[i]);
        }
        return dp0;
    }


    public int maxProfitS(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}

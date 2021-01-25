package s0100;

/**
 * @author traceless
 */
public class N0188BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        return maxProfit(prices, prices.length, k);
    }

    /**
     * //                   dp[i-1][j][0]                 //  不操作
     * // dp[i][j][0] = max dp[i-1][j-1][1] + prices[i]   //  卖出
     * <p>
     * //                   dp[i-1][j][1]                 //  不操作
     * // dp[i][j][1] = max dp[i-1][j][0] - prices[i]     //  买入
     * <p>
     * // dp[0][j][0] = 0  // 无操作，收益为 0
     * // dp[0][j][1] = Integer.MIN_VALUE  // 不合法的操作，置为最小值
     *
     * @param prices  股票价格数组
     * @param days    总的天数
     * @param maxTran 最大交易次数
     * @return 最大收益
     */
    public int maxProfit(int[] prices, int days, int maxTran) {
        if (maxTran > days / 2) {
            return quickSolve(prices);
        }

        int[][][] dp = new int[days + 1][maxTran + 1][2];
        for (int j = 0; j <= maxTran; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= days; i++) {
            for (int j = 1; j <= maxTran; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
            }
        }
        return dp[days][maxTran][0];
    }

    public int quickSolve(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(prices[i] - prices[i - 1], 0);
        }
        return profit;
    }
}

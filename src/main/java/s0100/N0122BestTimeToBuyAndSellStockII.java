package s0100;

public class N0122BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; ++i) {
            max += Math.max(prices[i] - prices[i - 1], 0);
        }
        return max;
    }
}

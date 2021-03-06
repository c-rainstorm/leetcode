package s0300;

public class N0322CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; ++i) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] < min) {
                    min = dp[i - coin] + 1;
                }
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

package s0500;

public class N0518CoinChange2 {

    /**
     * https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-ii-by-leetcode/
     * <p>
     * dp[i] 为给定硬币组合，组合成 i 的个数
     *
     * @TimeComplexity O(N * amount)
     * @SpaceComplexity O(amount)
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; ++i) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}

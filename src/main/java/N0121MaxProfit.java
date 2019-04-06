import org.junit.Test;

/**
 * [121] 买卖股票的最佳时机
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
 * <p>
 * algorithms
 * Easy (48.86%)
 * Total Accepted:    37.5K
 * Total Submissions: 76.6K
 * Testcase Example:  '[7,1,5,3,6,4]'
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * ⁠    注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @author baochen1.zhang
 * @date 2019.04.06
 */
public class N0121MaxProfit {
    @Test
    public void case1() {
        assert 0 == maxProfit(new int[]{7, 6, 4, 3, 1});
    }

    @Test
    public void case2() {
        assert 5 == maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }

    @Test
    public void case3() {
        assert 0 == maxProfit(new int[]{});
    }

    @Test
    public void case4() {
        assert 0 == maxProfit(new int[]{7});
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}
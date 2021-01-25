package s0400;

import org.junit.Test;

import java.util.Arrays;

public class N0416PartitionEqualSubsetSum {
    @Test
    public void case1() {
        assert canPartition(new int[]{1, 5, 11, 5});
    }

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if ((sum & 1) == 1) return false;
        sum >>= 1;
        if (sum < max) return false;
        if (sum == max) return true;

        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[len][sum + 1];

        dp[0][nums[0]] = true;
        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = nums[i - 1]; j <= sum; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][sum];
    }

    public static void print(int[][] a) {
        System.out.println("-------------------------------");
        for (int[] i : a) {
            System.out.println(Arrays.toString(i));
        }
    }
}

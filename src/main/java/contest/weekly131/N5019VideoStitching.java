package contest.weekly131;

import org.junit.Test;

import java.util.BitSet;

/**
 * @author baochen1.zhang
 * @date 2019.04.07
 */
public class N5019VideoStitching {

    @Test
    public void case1() {
        assert 3 == videoStitching(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10);
    }

    @Test
    public void case2() {
        assert -1 == videoStitching(new int[][]{{0, 1}, {1, 2}}, 5);
    }


    @Test
    public void case3() {
        assert 3 == videoStitching(new int[][]{{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}}, 9);
    }

    @Test
    public void case4() {
        assert 2 == videoStitching(new int[][]{{0, 4}, {2, 8}}, 5);
    }

    @Test
    public void case5() {
        assert 2 == videoStitching(new int[][]{{0, 5}, {1, 6}, {2, 7}, {3, 8}, {4, 9}, {5, 10}, {6, 11}, {7, 12}, {8, 13}, {9, 14}, {10, 15}, {11, 16}, {12, 17}, {13, 18}, {14, 19}, {15, 20}, {16, 21}, {17, 22}, {18, 23}, {19, 24}, {20, 25}, {21, 26}, {22, 27}, {23, 28}, {24, 29}, {25, 30}, {26, 31}, {27, 32}, {28, 33}, {29, 34}, {30, 35}, {31, 36}, {32, 37}, {33, 38}, {34, 39}, {35, 40}, {36, 41}, {37, 42}, {38, 43}, {39, 44}, {40, 45}, {41, 46}, {42, 47}, {43, 48}, {44, 49}, {45, 50}, {46, 51}, {47, 52}, {48, 53}, {49, 54}}
                , 50);
    }

    private int minTime = Integer.MAX_VALUE;
    private BitSet target;

    /**
     * from
     * https://leetcode-cn.com/contest/weekly-contest-131/ranking
     * rank 25 https://leetcode-cn.com/zhui-feng-hun-zi/
     * @param clips
     * @param T
     * @return
     */
    public int AC(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        for (int i = 1; i < T + 1; ++i)
            dp[i] = T + 1;
        for (int i = 1; i <= T; ++i) {
            for (int j = 0; j < clips.length; ++j) {
                if (clips[j][0] < i && clips[j][1] >= i)
                    dp[i] = Math.min(dp[i], dp[clips[j][0]] + 1);
            }
        }
        if (dp[T] > T)
            return -1;
        return dp[T];
    }

    /**
     * case 5  超时
     *
     * @param clips
     * @param t
     * @return
     */
    public int videoStitching(int[][] clips, int t) {
        t++;
        target = new BitSet(t);
        target.set(0, t);

        BitSet[] bitSets = buildBitSet(clips, t);
        if (cantSuccess(bitSets, t)) {
            return -1;
        }

        videoStitching(new BitSet(t), bitSets, 0, 0, t);
        return minTime;
    }

    private void videoStitching(BitSet current, BitSet[] bitSets, int index, int count, int t) {
        if (target.equals(current.get(0, t))) {
            minTime = Math.min(minTime, count);
            return;
        }

        if (index >= bitSets.length) {
            return;
        }

        BitSet bitSet = new BitSet(t);
        bitSet.or(current);
        bitSet.or(bitSets[index]);

        videoStitching(current, bitSets, index + 1, count, t);
        videoStitching(bitSet, bitSets, index + 1, count + 1, t);
    }

    private boolean cantSuccess(BitSet[] bitSets, int t) {

        BitSet result = new BitSet(t);
        for (BitSet bitSet : bitSets) {
            result.or(bitSet);
        }

        return !target.equals(result.get(0, t));
    }

    private BitSet[] buildBitSet(int[][] clips, int t) {
        BitSet[] bitSets = new BitSet[clips.length];
        for (int i = 0; i < clips.length; ++i) {
            bitSets[i] = new BitSet(t);
            bitSets[i].set(clips[i][0], clips[i][1] + 1);
        }
        return bitSets;
    }
}

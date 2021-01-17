package s0000;

public class N0052NQueensII {
    public int totalNQueens(int n) {
        return solve(n, 0, 0, 0, 0);
    }

    /**
     * pie ，na 只保存当前行
     */
    public int solve(int n, int row, int col, int pie, int na) {
        if (row >= n) return 1;

        int count = 0;
        int bits = ((1 << n) - 1) & (~(col | pie | na));
        while (bits != 0) {
            // 取最后一个Bit
            int p = bits & (-bits);
            // 占用这个位置
            count += solve(n, row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
            // 移除最后一个Bit
            bits = bits & (bits - 1);
        }
        return count;
    }
}

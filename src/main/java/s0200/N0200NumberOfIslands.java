package s0200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author traceless
 */
public class N0200NumberOfIslands {

    static class UnionFind {
        int[] roots;

        public UnionFind(int N) {
            roots = new int[N];
            for (int i = 0; i < N; i++) {
                roots[i] = i;
            }
        }

        public int find(int x) {
            int root = x;
            while (root != roots[root])
                root = roots[root];
            while (x != roots[x]) {
                int tmp = roots[x];
                roots[x] = root;
                x = tmp;
            }
            return root;
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            roots[xRoot] = yRoot;
        }

        public int count() {
            int count = 0;
            for (int i = 0; i < roots.length; ++i) {
                if (i == roots[i]) count++;
            }
            return count;
        }
    }


    public int unionFind(char[][] grid) {
        if (grid.length == 0) return 0;
        if (grid[0].length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        UnionFind unionFind = new UnionFind(rows * cols);

        int space = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == '0') {
                    space++;
                } else {
                    if (i > 0 && grid[i - 1][j] == '1') unionFind.union(toIndex(i - 1, j, cols), toIndex(i, j, cols));
                    if (j > 0 && grid[i][j - 1] == '1') unionFind.union(toIndex(i, j - 1, cols), toIndex(i, j, cols));
                }
            }
        }

        return unionFind.count() - space;
    }

    private int toIndex(int x, int y, int cols) {
        return x * cols + y;
    }

    public int dfs(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (grid[r][c] == '1') {
                    ++ans;
                    dfs(grid, r, c);
                }
            }
        }

        return ans;
    }

    void dfs(char[][] grid, int row, int col) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (row < 0 || col < 0 || row >= nr || col >= nc || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    public int bfs(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;

        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (grid[r][c] == '1') {
                    ++ans;
                    grid[r][c] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(r * cols + c);
                    while (!queue.isEmpty()) {
                        int id = queue.poll();
                        int row = id / cols;
                        int col = id % cols;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            queue.add((row - 1) * cols + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < rows && grid[row + 1][col] == '1') {
                            queue.add((row + 1) * cols + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            queue.add(row * cols + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < cols && grid[row][col + 1] == '1') {
                            queue.add(row * cols + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }

        return ans;
    }
}

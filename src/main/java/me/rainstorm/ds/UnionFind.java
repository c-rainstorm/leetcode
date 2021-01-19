package me.rainstorm.ds;

/**
 * @author traceless
 */
public class UnionFind {
    private int[] roots;

    public UnionFind(int N) {
        roots = new int[N];
        for (int i = 0; i < N; i++) {
            roots[i] = i;
        }
    }

    public int findRoot(int i) {
        int root = i;
        while (root != roots[root])
            root = roots[root];
        // 压缩路径，把路径上的所有节点的父节点都指向根节点
        while (i != roots[i]) {
            int tmp = roots[i];
            roots[i] = root;
            i = tmp;
        }
        return root;
    }

    public boolean connected(int x, int y) {
        return findRoot(x) == findRoot(y);
    }

    public void union(int x, int y) {
        int xRoot = findRoot(x);
        int yRoot = findRoot(y);
        roots[xRoot] = yRoot;
    }

}

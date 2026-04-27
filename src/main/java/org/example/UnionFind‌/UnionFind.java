package org.example.UnionFind‌;

public class UnionFind {

    private int[] pa;

    private int[] rank;

    public UnionFind(int n) {
        pa = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            pa[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (pa[x] != x) {
            pa[x] = find(pa[x]);
        }
        return pa[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                pa[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                pa[rootX] = rootY;
            } else {
                pa[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}

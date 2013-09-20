public class QuickUnion implements UnionFind {
    private int[] id;

    public QuickUnion(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    private int rootOf(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public boolean isConnected(int i, int j) {
        return rootOf(i) == rootOf(j);
    }

    public void union(int i, int j) {
        id[rootOf(i)] = rootOf(j);
    }

}
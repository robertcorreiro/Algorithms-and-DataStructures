public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int n) {
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

    public boolean isConnected(int p, int q) {
        return rootOf(p) == rootOf(q);
    }

    public void union(int p, int q) {
        id[rootOf(p)] = rootOf(q);
    }

}
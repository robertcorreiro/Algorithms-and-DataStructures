public class WeightedQuickUnion {
    private int[] id, sz;
    
    public WeightedQuickUnion(int n) {
        id = new int[n];
        sz = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int rootOf(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];  // path compression heuristic
            i = id[i];
        }
        return i;
    }

    public boolean isConnected(int i, int j) {
        return rootOf(i) == rootOf(j);
    }

    public void union(int i, int j) {
        // get root of i, root of j
        // smaller tree goes under bigger tree
        int iRoot = rootOf(i);
        int jRoot = rootOf(j);

        // root of i's tree is smaller
        if (sz[iRoot] < sz[jRoot]) {
            id[iRoot] = jRoot;
            sz[jRoot] += sz[iRoot];
        } else { 
            id[jRoot] = iRoot;
            sz[iRoot] += sz[jRoot];
        }
    }
}
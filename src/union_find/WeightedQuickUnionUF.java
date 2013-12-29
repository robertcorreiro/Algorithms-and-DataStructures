public class WeightedQuickUnionUF {
    int[] sz;  // size of tree under each node
    int[] id;  // pointer to parent node

    public WeightedQuickUnionUF(int n) {
        id = new int[n];
        sz = new int[n];

        for(int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int getRoot(int i) {
        while(id[i] != i) {
            id[i] = id[id[i]];  // path compression heuristic
            i = id[i];
        }
        return i;
    }

    public boolean connected(int i, int j) {
        return getRoot(i) == getRoot(j);   
    }

    public void union(int i, int j) {
        int p = getRoot(i);
        int q = getRoot(j);
        if(sz[p] > sz[q]) {
            id[q] = p;
            sz[p] += sz[q];
        } else {
            id[p] = q;
            sz[q] += sz[p];
        }
    }

    public static void main(String[] args) {
        int n = 10;

        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);

        uf.union(1,2);
        uf.union(1,3);
        uf.union(4,2);
        uf.union(5,6);
        uf.union(7,9);
        uf.union(8,9);

        System.out.println("Should be TRUE: " + uf.connected(1,4));
        System.out.println("Should be TRUE: " + uf.connected(3,4));
        System.out.println("Should be TRUE: " + uf.connected(5,6));
        System.out.println("Should be TRUE: " + uf.connected(7,9));
        System.out.println("Should be TRUE: " + uf.connected(8,7));

        System.out.println("Should be FALSE: " + uf.connected(1,5));
        System.out.println("Should be FALSE: " + uf.connected(1,8));
        System.out.println("Should be FALSE: " + uf.connected(6,2));
        System.out.println("Should be FALSE: " + uf.connected(6,9));
        System.out.println("Should be FALSE: " + uf.connected(9,3));
    }
}
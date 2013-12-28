public class Percolation {
    int TOP;  // virtual top site
    int BOTTOM;  // virtual bottom site

    boolean[] openSites;
    WeightedQuickUnionUF uf;
    int n;

    // Creates n-by-n grid, with all sites blocked
    public Percolation(int n) {
        int size = (n*n) + 2;
        this.n = n;
        uf = new WeightedQuickUnionUF(size);
        openSites = new boolean[size];
        
        TOP = 0;
        BOTTOM = size - 1;

        openSites[TOP] = true;
        openSites[BOTTOM] = true;

        for (int i = 1; i < size-1; i++) {
            openSites[i] = false;
        }
    }

    private int indexOf(int i, int j) {
        if (i == 0) {
            return j;
        }
        return (i-1)*n + j;
    }

    private boolean inRange(int i, int j) {
        return i >= 0 && j >= 0 && i <= n && j <= n;
    }

    // Opens site at row i, col j if not already open
    public void open(int i, int j) {
        if (isOpen(i,j)) {
            return;
        }

        openSites[indexOf(i,j)] = true;

        // Check if newly opened site is in first or last row
        if (i == 0) {
            uf.union(TOP, indexOf(i,j));
        } 
        if (i == n) {
            uf.union(BOTTOM, indexOf(i,j));
        }

        // top, left, down, right
        int[] x = {i-1, i, i+1, i};
        int[] y = {j, j-1, j, j+1};

        for (int k = 0; k < x.length; k++) {
            if (inRange(x[k],y[k]) && isOpen(x[k],y[k])) {
                uf.union(indexOf(x[k],y[k]), indexOf(i,j));
            }
        }
    }

    public boolean isOpen(int i, int j) {
        return openSites[indexOf(i,j)];
    }

    public boolean isFull(int i, int j) {
        return uf.connected(indexOf(i,j), TOP);
    }

    // Checks if the system percolates
    public boolean percolates() {
        return uf.connected(TOP, BOTTOM);
    }

    // Test Client
    public static void main(String[] args) {
        int n = 20;
        Percolation p = new Percolation(n);
        while(!p.percolates()) {
            int j = StdRandom.uniform(n*n + 1);
            int row = j / n;
            int col = j % n;
            p.open(row,col);
            System.out.println("Opened: " + row + ", " + col);
        }
        System.out.println("PERCOLATES!");
    }
}
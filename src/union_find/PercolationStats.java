public class PercolationStats {
    private double[] results;
    private int numExp;

    // Performs t independent experiments on an n-by-n grid
    public PercolationStats(int n, int t) {
        Percolation perc;
        int row, col, open;
        numExp = t;
        results = new double[numExp];

        for(int i = 0; i < numExp; i++) {
            perc = new Percolation(n);
            open = 0;


            while(!perc.percolates()) {
                int j = StdRandom.uniform(n*n) + 1;
                
                if (j % n == 0) {
                    row = j / n;
                    col = n;
                } else {
                    row = (j / n) + 1;    
                    col = j % n;
                }            
                
                try {
                    perc.open(row,col);    
                } catch (IndexOutOfBoundsException e) {

                }
            }

            for(int k = 1; k < n*n+1; k++) {
                row = k / n;
                col = k % n;
                try {
                    if (perc.isOpen(row,col)) {
                        open++;
                    }
                } catch (IndexOutOfBoundsException e) {
                    
                }
            }
            //System.out.println("open = " + open + "\n(n*n) = " + (n*n));
            results[i] = (double) open / (n*n);
            //System.out.println(results[i]);
        }
    }

    // Sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // Sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    // Returns lower bound of the 95% confidence interval
    public double confidenceLo() {
        return mean() - (1.96 * stddev() / Math.sqrt(numExp));
    }

    // Returns upper bound of the 95% confidence interval
    public double confidenceHi() {
        return mean() + (1.96 * stddev() / Math.sqrt(numExp));
    }

    // Test client
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        
        PercolationStats ps = new PercolationStats(n, t);
        System.out.println("mean                    = " + ps.mean());
        System.out.println("stddev                  = " + ps.stddev());
        System.out.println("95% confidence interval = " + ps.confidenceLo() +
                            ", " + ps.confidenceHi());
    }
}
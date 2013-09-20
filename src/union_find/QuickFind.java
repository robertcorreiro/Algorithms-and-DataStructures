public class QuickFind implements UnionFind {
	private int[] id;

	public QuickFind(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++)
				id[i] = i;
	}

    public boolean isConnected(int i, int j) {
        // Connected if they have the same id
        return id[i] == id[j];
    }

	public void union(int i, int j) {
        // Change all entries whose id is id[i] to id[j]
        int iID = id[i];
        int jID = id[j];
        for (int k = 0; k < id.length; k++)
            if (id[k] == iID)
                id[k] = jID;
	}

}
public class QuickFindUF {
	private int[] id;

	public QuickFindUF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++)
				id[i] = i;
	}

    public boolean connected(int p, int q) {
        // Connected if they have the same id
        return id[p] == id[q];
    }

	public void union(int p, int q) {
        // Change all entries whose id is id[p] to id[q]
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++)
            if (id[i] == pid)
                id[i] = qid;
	}

}
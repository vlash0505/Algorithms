public class UnionFind {
    private int[] id;           // element's index
    private int[] size;         // size of each connected component
    private int connectedNum;   // number of connected components

    /*
     * Constructor to initialize an object of UnionFind class
     *
     * @param N - number of elements in a set.
     */

    public UnionFind(int N) {
        id = new int[N];
        size = new int[N];
        connectedNum = N;
        for (int i : id) {
            id[i] = i;
            size[i] = 1;
        }
    }

    /*
     * Method to find a root of a tree which contains an element.
     * In addition we implemented path compression
     * in order to make time complexity smaller.
     *
     * @param i - element we will find a root of.
     *
     * @return the root of a tree which contains element i.
     */

    public int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];       // implementing path compression
            i = id[i];
        }
        return i;
    }

    /*
     * Method to check whether two elements are connected.
     *
     * @param p - first element.
     * @param q - second element.
     *
     * @return true if elements are connected, false - if not.
     */

    public boolean find(int p, int q) { return (root(p) == root(q)); }

    /*
     * Method to unite two elements of a set.
     * Adjusting smaller tree to a larger one.
     *
     * @param p - first element to unite.
     * @param q - second element to unite.
     */

    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (size[rootP] >= size[rootQ]) { id[q] = rootP; size[rootP] += size[rootQ]; }
        else                            { id[p] = rootQ; size[rootQ] += size[rootP]; }
        connectedNum--;
    }
}
import edu.princeton.cs.algs4.StdIn;

/*
* Driver class to implement the code from UnionFind.java.
* Using external library edu.princeton.cs.algs4.StdIn
* to read numbers from .txt file.
*/

public class UnionFindDriver {
    public static void main(String[] args) {
        int N = StdIn.readInt();                  // Reading amount of elements in a set
        UnionFind example = new UnionFind(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!example.find(p,q)) { example.union(p,q); }
        }
    }
}
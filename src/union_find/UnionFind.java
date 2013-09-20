/** UnionFind.java
 *  A simple interface for representing connected components
 *  in an undirected graph using integers as node IDs.
 */
public interface UnionFind {

  /**
   * Returns a boolean representing if one node is 
   * connected to another.
   * 
   * @param i Index of first node
   * @param j Index of second node
   * @return  True if the nodes are connected, false otherwise
   */
  boolean isConnected(int i, int j);

  /**
   * Creates a connection between two nodes, merging their 
   * components together.
   * 
   * @param i Index of first node
   * @param j Index of second node
   */
  void union(int i, int j);
}
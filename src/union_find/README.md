Connected Components
===========================

## Problem: Dynamic connectivity

Motivating Questions:

Is there a path between... 
  
   * Computers in a network?
   * Pixels in a digital photo?
   * Transistors in a computer chip?
   
============================

The **union-find** data type models the *partitioning* of a set of elements, in order to keep track of *connected components* in an *undirected graph*.

The algorithms will perform two main operations:

  * **Find** - check if two elements are in the same subset. (Are they connected?)
  * **Union** - merge two subsets into one.

===========================

### Implementations:

  * Java
   * [Quick-Find](https://github.com/robertcorreiro/Algorithms-and-DataStructures/blob/master/src/union_find/QuickFind.java)
   * [Quick-Union](https://github.com/robertcorreiro/Algorithms-and-DataStructures/blob/master/src/union_find/QuickUnion.java)
   * [Weighted Quick-Union with Path Compression](https://github.com/robertcorreiro/Algorithms-and-DataStructures/blob/master/src/union_find/WeightedQuickUnion.java)
  * Ruby
   * [Weighted Quick-Union with Path Compression](https://github.com/robertcorreiro/Algorithms-and-DataStructures/blob/master/src/union_find/WeightedQuickUnion.rb)
===========================

### Other Union-find applications:

  * Used as a subroutine in Kruskal's MST algorithm
  * Image processing
  * Physics: Hoshen-Kopelman algorithm
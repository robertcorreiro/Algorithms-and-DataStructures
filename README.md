Algorithms & Data Structures
============================

A list of various useful data types, algorithms, and data structures.

============================

Details:

* I will be implementing all programs in Java.
* Feel free to fork and practice in your own language.

============================

## Connected Components

The **union-find** data type models the *partitioning* of a set of elements, in order to keep track of *connected components* in an *undirected graph*.

The algorithm will perform two main operations:

  * **Union** - merge two components, or subsets.
  * **Find** - check if two elements are in the same component or subset. (Are they connected?)
  

### Implementation:

  * [WeightedQuickUnionUF.java](https://github.com/robertcorreiro/Algorithms-and-DataStructures/blob/master/src/union_find/WeightedQuickUnionUF.java)
  
### Applications:
  Scientists have defined an abstract process known as *percolation* to model situations such as: water draining through a porous surface or oil gushing through to the surface from below. 

  * [Percolation.java](https://github.com/robertcorreiro/Algorithms-and-DataStructures/blob/master/src/union_find/Percolation.java) - API to model a percolation system.
  * [PercolationStats.java](https://github.com/robertcorreiro/Algorithms-and-DataStructures/blob/master/src/union_find/PercolationStats.java) - performs a Monte Carlo simulation to estimate the percolation threshold.
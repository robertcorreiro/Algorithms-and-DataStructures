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

The algorithm will perform two main operations:

  * **Union** - merge two components, or subsets.
  * **Find** - check if two elements are in the same component or subset. (Are they connected?)
  

### Implementation:

  * [WeightedQuickUnionUF.java](https://github.com/robertcorreiro/Algorithms-and-DataStructures/blob/master/src/union_find/WeightedQuickUnionUF.java)
  
### Applications:
  Scientists have defined an abstract process known as *percolation* to model situations such as: water draining through a porous surface or oil gushing through to the surface from below. 

  * [Percolation.java](https://github.com/robertcorreiro/Algorithms-and-DataStructures/blob/master/src/union_find/Percolation.java) - API to model a percolation system.
  * [PercolationStats.java](https://github.com/robertcorreiro/Algorithms-and-DataStructures/blob/master/src/union_find/PercolationStats.java) - performs a Monte Carlo simulation to estimate the percolation threshold.
===========================

### Other Union-find applications:

  * Used as a subroutine in Kruskal's MST algorithm
  * Image processing
  * Physics: Hoshen-Kopelman algorithm
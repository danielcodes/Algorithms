##SORTING

###One - Insertion Sort
Implement insertion sort with both shift and swap and show that swap is more efficient

###Two - Directed Graph
Implement a function that takes in a directed graph (2D array), with it's containing values (another array), computes the aggregate values of each vertex and sort.
Return an array with the sorted indices, not values.

###Three - Hybrid Sort (Merge + Insertion)
Create a hybrid algorithm that fuses insertion and merge. Through trial and error, find the N value for which insertion sort is faster than merge (use nanotime). Then merge's base case occurs when N drops below the found value.

###Four - Radix Sort and Quick Sort
Differs from merge, by doing the work in the divide part
A pivot is found, through a partition function in this particular implementation
it will be the last element, this selected pivot get placed in the correct array location and from there, quicksort is called recursively again, on the 2 divided
sides

##DYNAMIC PROGRAMMING AND GREEDY ALGORITHMS

###Five - Weighted Interval Scheduling
A set of intervals over a period of time that have a values. For intervals to be compatible, there mustn't be overlap in time. The goal is to find a combination of intervals that contain the largest value with no overlap.

###Six - Graph Coloring
Use a greedy algorithm to color a graph, so that it uses the least amount of colors and no adjacent vertices have the same color.

###Seven - Dijkstra Shortest Path
Given a graph find the shortest path, between any two pair of vertices

# Algorithms

Programming assignments for my algorithms class

Numero Uno
-Implement insertion sort with both shift and swap and show that swap is more efficient

Numero Dos
-Implement a function that takes in a directed graph (2D array), with it's containing values (another array), computes the aggregate values of each vertex and sort.
Return an array with the sorted indices, not values.

Numero Tres
-Create a hybrid algorithm that fuses insertion and merge. Through trial and error, find the N value for which insertion sort is faster than merge (use nanotime). Then merge's base case occurs when N drops below the found value.

Numero Cuatro
-Radix and Quick
--Quicksort
Differs from merge, by doing the work in the divide part
A pivot is found, through a partition function in this particular implementation
it will be the last element, this selected pivot get placed in the correct array location and from there, quicksort is called recursively again, on the 2 divided
sides

Okay, let's expand on that flowchart with more detail, context, and common scenarios. This guide provides heuristics – common patterns and starting points – but always analyze the specific problem constraints (time/space complexity, input size, data range) before committing to an algorithm.

Here's a more structured and detailed breakdown:

Algorithm Selection Guide for Common Coding Patterns

This guide helps identify potential algorithms based on input characteristics and problem types frequently encountered in coding interviews and competitive programming.

1. Input: Sorted Array / List

Primary Algorithms:

Binary Search:

Why? Extremely efficient (O(log n)) for searching or finding positions in sorted data.

Use Cases: Finding a specific element, finding the first/last occurrence of an element, finding the smallest element greater than/less than a target, finding insertion points, searching in rotated sorted arrays (requires modification).

Considerations: Requires the array to be sorted. Be careful with off-by-one errors and loop termination conditions.

Two Pointers:

Why? Efficiently traverse the array (O(n)) by comparing elements from different positions simultaneously (e.g., opposite ends, or one fast/one slow).

Use Cases: Finding pairs/triplets that sum to a target value, removing duplicates from a sorted array, checking for palindromes, merging sorted arrays (conceptually), "Container With Most Water" type problems.

Considerations: Relies on the sorted property to make decisions about moving pointers.

Related:

Sliding Window: While often used on unsorted arrays too, it can be applicable on sorted arrays for problems involving contiguous subarrays with certain properties (e.g., finding a subarray with a sum closest to a target).

2. Problem: Generate All Permutations / Subsets / Combinations

Primary Algorithm:

Backtracking (Recursion):

Why? It systematically explores all possible candidates by building a solution step-by-step. If a partial candidate can't lead to a valid complete solution, it "backtracks."

Use Cases: Generating all permutations of a set, finding all subsets (powerset), finding all combinations that sum to a target, solving puzzles (Sudoku, N-Queens), graph/tree pathfinding where all paths are needed.

Considerations: Can be computationally expensive (often factorial or exponential time complexity). Pay attention to the base cases and the "choose/explore/unchoose" pattern in the recursive calls. Pass copies or modify/revert state carefully.

3. Input: Tree

Primary Algorithms:

Depth-First Search (DFS - Recursion/Stack):

Why? Explores as far down a branch as possible before backtracking. Naturally implemented using recursion (implicit stack) or an explicit stack.

Use Cases: Tree traversals (pre-order, in-order, post-order), finding paths between nodes, checking if a path exists, determining tree height/depth, checking structural properties (e.g., symmetric tree), cycle detection (in graphs, adapted for trees).

Considerations: Recursive DFS is often cleaner code but can lead to stack overflow for very deep trees. Iterative DFS uses an explicit stack.

Breadth-First Search (BFS - Queue):

Why? Explores nodes level by level. Uses a queue to manage nodes to visit.

Use Cases: Level-order traversal, finding the shortest path between two nodes (in terms of edges), finding nodes at a specific depth, finding the minimum depth of a tree.

Considerations: Guarantees finding the shortest path in unweighted graphs/trees. Requires a queue data structure.

4. Input: Graph

Primary Algorithms:

Depth-First Search (DFS - Recursion/Stack):

Why? Exploration strategy, same as for trees but needs careful handling of visited nodes to prevent infinite loops in cyclic graphs.

Use Cases: Finding connected components, cycle detection, topological sorting (with modifications), pathfinding.

Considerations: Requires a visited set/array. Order of exploration depends on adjacency list order and starting node.

Breadth-First Search (BFS - Queue):

Why? Exploration strategy, same as for trees but needs careful handling of visited nodes.

Use Cases: Finding shortest paths in unweighted graphs, finding connected components, web crawlers (conceptual).

Considerations: Requires a visited set/array. Guarantees shortest path (edge count).

Other Graph Algorithms (Mentioned for Completeness):

Dijkstra's Algorithm: Shortest path in weighted graphs (non-negative weights). Often uses a priority queue.

Bellman-Ford Algorithm: Shortest path in weighted graphs (handles negative weights, detects negative cycles).

Floyd-Warshall Algorithm: All-pairs shortest paths.

Prim's / Kruskal's Algorithm: Minimum Spanning Tree (MST).

Topological Sort: Ordering nodes in a Directed Acyclic Graph (DAG) based on dependencies. (Can use DFS or BFS based approaches).

5. Input: Linked List

Primary Algorithm:

Two Pointers:

Why? Essential technique due to lack of random access. Pointers can move at different speeds (fast/slow) or start from different points (though finding the end requires a first pass).

Use Cases: Detecting cycles (Floyd's Tortoise and Hare), finding the middle node, reversing a linked list, merging two sorted lists, removing the Nth node from the end, checking for palindromes.

Considerations: Be very careful with null checks and pointer assignments (order matters!).

6. Constraint: Recursion is Banned / Avoid Stack Overflow

Primary Data Structure:

Stack:

Why? An iterative approach using an explicit stack can mimic the function call stack used by recursion.

Use Cases: Converting recursive DFS traversals (tree/graph) to iterative, evaluating Reverse Polish Notation, validating parentheses, simplifying file paths.

7. Constraint: Must Solve In-Place (O(1) Extra Space)

Primary Techniques:

Swap Corresponding Values:

Why? Directly manipulates the input array/list elements without auxiliary data structures proportional to input size.

Use Cases: Reversing an array/string, some sorting algorithms (Bubble, Selection, parts of QuickSort), rearranging elements (e.g., move zeros to end).

Store Multiple Values / Use Input Array State:

Why? Cleverly uses the existing memory space (e.g., array elements, node pointers) to store additional state information.

Use Cases: Using the sign of array elements to mark visited status (if numbers are positive), cycle sort pattern for finding missing/duplicate numbers, encoding two values in one location (less common), reversing linked list segments without extra nodes. Example: Find the First Missing Positive.

8. Problem: Maximum / Minimum Subarray / Subset / Options

Primary Algorithm:

Dynamic Programming (DP):

Why? Problems often have "optimal substructure" (optimal solution can be constructed from optimal solutions of subproblems) and "overlapping subproblems" (the same subproblems are solved multiple times). DP stores results of subproblems to avoid recomputation.

Use Cases: Maximum subarray sum (Kadane's algorithm), Longest Increasing Subsequence, Longest Common Subsequence/Substring, Edit Distance, Coin Change problems, Knapsack problems, distinct ways to reach a point/score.

Considerations: Identify the state definition (dp[i] = ?), the recurrence relation (how dp[i] relates to previous states), and the base cases. Can be implemented top-down (memoization/recursion) or bottom-up (tabulation/iteration).

9. Problem: Find Top / Least K items

Primary Algorithms:

Heap (Priority Queue):

Why? Maintains the K largest/smallest elements encountered so far efficiently. Inserting/extracting takes O(log K) time. Total time O(N log K).

Use Cases: Find the Kth largest/smallest element, Top K frequent elements, merge K sorted lists.

Considerations: Easy to implement using built-in library functions. Space complexity is O(K).

QuickSelect:

Why? Modification of the QuickSort partitioning algorithm. Finds the Kth smallest (or largest) element directly. Average time O(N), worst-case O(N^2).

Use Cases: Find the Kth largest/smallest element.

Considerations: Often faster in practice than heaps for large N, especially if an in-place partition is used (O(1) space). Implementation requires care (pivot selection, handling duplicates). Can be less intuitive than heaps.

10. Problem: Dealing with Strings / Common Prefixes / Frequencies

Primary Data Structures:

Map (Hash Map / Dictionary):

Why? Provides O(1) average time complexity for insertion, deletion, and lookup based on keys.

Use Cases: Counting character/word frequencies, checking for anagrams, finding pairs that sum to a target (storing complements), implementing caches (LRU Cache often uses a Map + List), checking if items exist in a collection.

Trie (Prefix Tree):

Why? Specialized tree structure optimized for prefix-based operations. Each node represents a character, path from root represents a prefix/word.

Use Cases: Implementing autocomplete features, dictionary lookups, finding all words with a common prefix, spell checkers, IP routing tables (conceptually).

Considerations: Space can be significant if strings are long and diverse. Node structure typically contains children pointers (often an array or map) and an end-of-word marker.

11. Default / General Purpose Strategies

If Time is Critical & Lookup/Existence Check is Needed:

Map / Set (Hash Map / Hash Set):

Why? O(1) average time complexity for lookups, insertions, deletions.

Tradeoff: Uses O(N) extra space.

If Order Matters or Enables Other Algorithms:

Sorting:

Why? Arranges data in a way that enables efficient algorithms like Binary Search or Two Pointers. Can also simplify problems involving duplicates or finding ranges.

Tradeoff: O(N log N) time complexity. Space complexity varies (O(1) for heapsort, O(log N) to O(N) for quicksort/mergesort depending on implementation).

Important Note: This is a set of guidelines, not absolute rules. The best algorithm depends on the specific constraints, edge cases, and nuances of the problem. Always start by understanding the problem deeply, analyzing constraints, and considering different approaches.
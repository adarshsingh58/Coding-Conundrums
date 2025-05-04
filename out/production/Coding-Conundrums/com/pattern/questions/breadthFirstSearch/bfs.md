Breadth-First Search (BFS) is a traversal technique that explores nodes level by level in a tree or graph.

Use this pattern for finding the shortest paths in unweighted graphs or level-order traversal in trees.
Sample Problem:

Perform level-order traversal of a binary tree.

Example:

    Input: root = [3, 9, 20, null, null, 15, 7]

    Output: [[3], [9, 20], [15, 7]]

Explanation:

    Use a queue to keep track of nodes at each level.

    Traverse each level and add the children of the current nodes to the queue.
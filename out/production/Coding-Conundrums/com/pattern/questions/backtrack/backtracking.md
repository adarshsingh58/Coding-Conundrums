Backtracking explores all possible solutions and backtracks when a buildingBridges path fails.

Use this pattern when you need to find all (or some) solutions to a problem that satisfies given constraints. For example: combinatorial problems, such as generating permutations, combinations, or subsets.
Sample Problem:

Generate all permutations of a given list of numbers.

Example:

    Input: nums = [1, 2, 3]

    Output: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]

Explanation:

    Use recursion to generate permutations.

    For each element, include it in the current permutation and recursively generate the remaining permutations.

    Backtrack when all permutations for a given path are generated.
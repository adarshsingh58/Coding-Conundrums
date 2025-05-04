package com.DataStructures_And_Questions.scenarioBasedQues;

/**
 * There are a total of n tasks you have to pick, labeled from 0 to n-1. Some tasks may have prerequisites tasks, for example to pick task 0 you have to first finish tasks 1, which is expressed as a pair: [0, 1]
 * <p>
 * Given the total number of tasks and a list of prerequisite pairs, return the ordering of tasks you should pick to finish all tasks.
 * <p>
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all tasks, return an empty array.
 * <p>
 * Input: 2, [[1, 0]]
 * Output: [0, 1]
 * Explanation: There are a total of 2 tasks to pick. To pick task 1 you should have finished task 0. So the correct task order is [0, 1] .
 * <p>
 * Input: 4, [[1, 0], [2, 0], [3, 1], [3, 2]]
 * Output: [0, 1, 2, 3] or [0, 2, 1, 3]
 * Explanation: There are a total of 4 tasks to pick. To pick task 3 you should have finished both tasks 1 and 2.
 * Both tasks 1 and 2 should be pick after you finished task 0. So one correct task order is [0, 1, 2, 3]. Another correct ordering is [0, 2, 1, 3].
 */
public class MavenDependencyProblem {

    public static void main(String[] args) {

    }

    /*
     *  We can consider this problem as a graph (related to topological sorting) problem.
     *  All tasks are nodes of the graph and if task u is a prerequisite of task v, we will add a directed edge from node u to node v. Now, this problem is equivalent to finding a topological ordering of nodes/tasks (using topological sorting) in the graph represented by prerequisites. If there is a cycle in the graph, then it is not possible to finish all tasks (because in that case there is no any topological order of tasks). Both BFS and DFS can be used for topological sorting to solve it.
     *  Since pair is inconvenient for the implementation of graph algorithms, we first transform it to a graph.
     *  If task u is a prerequisite of task v, we will add a directed edge from node u to node v.
     *
     *
     */
    public void resolveDependency() {

    }
}

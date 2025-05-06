package com.DataStructures_And_Questions.scenarioBasedQues;

/**
 * You are given an array heights[] representing the height of buildings aligned from left to right. The ocean is to the
 * right of the last building.
 * <p>
 * A building has an ocean view if all the buildings to its right are shorter than it.
 * <p>
 * You need to return the indices of all buildings that have an ocean view, in increasing order. Key Insight:
 * <p>
 * This is a monotonic sweep problem. You scan from right to left, keeping track of the maximum height you've seen so
 * far. If the current building is taller than all to its right, it gets an ocean view.
 * <p>
 * Input: heights = [4,2,3,1] Output: [0,2,3] Building 3 (height=1) has nothing to its right → ocean view ✅
 * <p>
 * Building 2 (height=3) > 1 → ocean view ✅
 * <p>
 * Building 1 (height=2) < 3 → no view ❌
 * <p>
 * Building 0 (height=4) > 3 → ocean view ✅
 * <p>
 * 🧩 Approach (Right-to-Left Sweep):
 * <p>
 * Initialize maxHeight = -1
 * <p>
 * Traverse heights from right to left:
 * <p>
 * If heights[i] > maxHeight:
 * <p>
 * Add i to result.
 * <p>
 * Update maxHeight = heights[i]
 * <p>
 * Reverse result (because we built it from right to left)
 */
public class BuildingsWithanOceanView {
}

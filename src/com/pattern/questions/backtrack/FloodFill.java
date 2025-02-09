package com.pattern.questions.backtrack;

/**
 * Statement
 * <p>
 * We are given the following values as input to begin with:
 * <p>
 * The coordinates of a source cell, i.e., sr and sc.
 * <p>
 * A target value, target.
 * <p>
 * An (m×n)(m×n) grid.
 * <p>
 * Our task is to perform flood fill by updating the values of the four directionally connected cells, which have the
 * same value as the source cell with the target value.
 * <p>
 * How to perform flood fill:
 * <p>
 * Suppose that a (4×4)(4×4) grid has a source value of 11 at coordinates [1,1][1,1]. We perform flood fill on its
 * neighboring cells only if they have the same source value as this cell. Once all adjacent cells are updated, return
 * the new grid after performing flood fill.
 * <p>
 * If no neighboring cell has a value equal to the source cell, only update the source cell with the target value and
 * return the updated grid.
 */
public class FloodFill {
}

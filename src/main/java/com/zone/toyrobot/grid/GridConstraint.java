package com.zone.toyrobot.grid;

/**
 * Grid Constraint
 * 
 * Constraints for the operation of the robot on the the grid.
 * 
 * @author Amit Modhvadia
 *
 */
public interface GridConstraint {

	/**
	 * Length of the grid.
	 */
	public static final int GRID_X_SIZE = 5;

	/**
	 * Width of the grid.
	 */
	public static final int GRID_Y_SIZE = 5;

	/**
	 * Checks whether the given x and y values are on the grid and not off the grid.
	 * 
	 * @param xValue
	 *            x coordinate
	 * @param yValue
	 *            y coordinate
	 * @return true if on the grid and false if off the grid
	 */
	public boolean onGrid(int xValue, int yValue);
}

package com.zone.toyrobot.grid;

/**
 * Grid command interface.
 * 
 * @author Amit Modhvadia
 *
 */
public interface GridCommand {

	/**
	 * Puts the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST
	 * or WEST.
	 * 
	 * @param robotXValue
	 *            the x coordinate on the grid
	 * @param robotYValue
	 *            the y coordinate on the grid
	 * @param robotFaceDirection
	 *            the face direction of the robot
	 * @return return true if the place command places the robot on a valid place on
	 *         the grid and not off the grid.
	 */
	public boolean place(int robotXValue, int robotYValue, String robotFaceDirection);

	/**
	 * Moves the toy robot one unit forward in the direction it is currently facing.
	 */
	public void move();

	/**
	 * Rotate the robot 90 degrees anti-clockwise without changing the position of the
	 * robot.
	 */
	public void left();

	/**
	 * Rotate the robot 90 degrees clockwise without changing the position of the robot.
	 */
	public void right();

	/**
	 * Outputs the X and Y coordinates, and the Face direction of the robot.
	 * 
	 * @return return the output in a string format
	 */
	public String report();
}

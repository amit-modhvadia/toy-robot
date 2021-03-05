package com.zone.toyrobot.grid;

import com.zone.toyrobot.FaceDirectionEnum;
import com.zone.toyrobot.ToyRobot;

/**
 * Representation of a grid implementing commands for the grid and the
 * constraints for the operation of the toy robot on the grid.
 * 
 * @author Amit Modhvadia
 *
 */
public class Grid implements GridCommand, GridConstraint {

	// Table top/the grid
	private ToyRobot[][] gridArray = new ToyRobot[GridConstraint.GRID_X_SIZE][GridConstraint.GRID_Y_SIZE];

	private static ToyRobot toyRobot = null;

	private static int currentXPosition = 0;

	private static int currentYPosition = 0;

	public Grid() {

		toyRobot = new ToyRobot();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zone.toyrobot.grid.GridCommand#move()
	 */
	@Override
	public void move() {

		int newXPosition = 0;
		int newYPosition = 0;

		switch (toyRobot.getFaceDirection()) {

		case NORTH:
			newXPosition = currentXPosition;
			newYPosition = currentYPosition + 1;
			break;

		case SOUTH:
			newXPosition = currentXPosition;
			newYPosition = currentYPosition - 1;
			break;

		case EAST:
			newXPosition = currentXPosition + 1;
			newYPosition = currentYPosition;
			break;

		case WEST:
			newXPosition = currentXPosition - 1;
			newYPosition = currentYPosition;
			break;
		}

		if (onGrid(newXPosition, newYPosition)) {

			gridArray[currentXPosition][currentYPosition] = null;

			gridArray[newXPosition][newYPosition] = toyRobot;
			currentXPosition = newXPosition;
			currentYPosition = newYPosition;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zone.toyrobot.grid.GridCommand#left()
	 */
	@Override
	public void left() {

		switch (toyRobot.getFaceDirection()) {

		case NORTH:
			toyRobot.setFaceDirection(FaceDirectionEnum.WEST);
			break;

		case SOUTH:
			toyRobot.setFaceDirection(FaceDirectionEnum.EAST);
			break;

		case EAST:
			toyRobot.setFaceDirection(FaceDirectionEnum.NORTH);
			break;

		case WEST:
			toyRobot.setFaceDirection(FaceDirectionEnum.SOUTH);
			break;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zone.toyrobot.grid.GridCommand#right()
	 */
	@Override
	public void right() {

		switch (toyRobot.getFaceDirection()) {

		case NORTH:
			toyRobot.setFaceDirection(FaceDirectionEnum.EAST);
			break;

		case SOUTH:
			toyRobot.setFaceDirection(FaceDirectionEnum.WEST);
			break;

		case EAST:
			toyRobot.setFaceDirection(FaceDirectionEnum.SOUTH);
			break;

		case WEST:
			toyRobot.setFaceDirection(FaceDirectionEnum.NORTH);
			break;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zone.toyrobot.grid.GridCommand#report()
	 */
	@Override
	public String report() {

		String reportOutput = "Output:" + currentXPosition + ", " + currentYPosition + ", "
				+ toyRobot.getFaceDirection();
		System.out.println(reportOutput);

		return reportOutput;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zone.toyrobot.grid.GridCommand#place(int, int, java.lang.String)
	 */
	@Override
	public boolean place(int robotXValue, int robotYValue, String robotFaceDirection) {

		if (onGrid(robotXValue, robotYValue)) {

			gridArray[currentXPosition][currentYPosition] = null;

			gridArray[robotXValue][robotYValue] = toyRobot;
			toyRobot.setFaceDirection(FaceDirectionEnum.valueOfFaceDirection(robotFaceDirection));

			currentXPosition = robotXValue;
			currentYPosition = robotYValue;

			return true;

		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zone.toyrobot.grid.GridConstraint#onGrid(int, int)
	 */
	@Override
	public boolean onGrid(int xValue, int yValue) {

		return (xValue >= 0 && xValue <= GridConstraint.GRID_X_SIZE - 1)
				&& (yValue >= 0 && yValue <= GridConstraint.GRID_Y_SIZE - 1);
	}

}

package com.zone.toyrobot;

/**
 * Toy Robot.
 * 
 * @author Amit Modhvadia
 *
 */
public class ToyRobot {

	private FaceDirectionEnum faceDirection;

	/**
	 * Constructor for the Toy Robot.
	 */
	public ToyRobot() {

		super();
	}

	/**
	 * Get the face direction of the toy robot.
	 * 
	 * @return face direction of the robot
	 */
	public FaceDirectionEnum getFaceDirection() {
		return faceDirection;
	}

	/**
	 * Set the face direction of the toy robot.
	 * 
	 * @param faceDirection
	 *            new face direction of the robot
	 */
	public void setFaceDirection(FaceDirectionEnum faceDirection) {
		this.faceDirection = faceDirection;
	}

}

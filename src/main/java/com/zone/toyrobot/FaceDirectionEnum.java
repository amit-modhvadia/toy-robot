package com.zone.toyrobot;

/**
 * Face Direction Enumeration.
 * 
 * @author Amit Modhvadia
 *
 */
public enum FaceDirectionEnum {

	NORTH("NORTH"), SOUTH("SOUTH"), EAST("EAST"), WEST("WEST");

	private String faceDirection;

	/**
	 * Get the Face Direction Value.
	 * 
	 * @return the face direction value
	 */
	public String getFaceDirection() {

		return this.faceDirection;
	}

	/**
	 * Return the equivalent Face Direction Enumeration given its face direction
	 * value.
	 * 
	 * @param faceDirection
	 *            face direction value
	 * @return Face Direction Enumeration
	 */
	public static FaceDirectionEnum valueOfFaceDirection(String faceDirection) {
		for (FaceDirectionEnum fde : values()) {
			if (fde.faceDirection.equals(faceDirection)) {
				return fde;
			}
		}
		return null;
	}

	// enum constructor - cannot be public or protected
	private FaceDirectionEnum(String faceDirection) {
		this.faceDirection = faceDirection;
	}
}

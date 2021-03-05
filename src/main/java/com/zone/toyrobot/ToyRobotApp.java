package com.zone.toyrobot;

import java.io.Console;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.zone.toyrobot.grid.Grid;

/**
 * Invokes the toy robot application.
 * 
 * If the application is invoked without any options then it is run from the
 * command line.
 * 
 * If the application is invoked with a filename provided as an option, then the
 * commands are read from the file.
 * 
 * @author Amit Modhvadia
 *
 */
public class ToyRobotApp {

	private static final String DELIMITER = ",";

	private static final String SPACE = " ";

	private static final String EMPTY_STRING = "";

	private static final String MOVE_COMMAND = "move";

	private static final String PLACE_COMMAND = "place";

	private static final String LEFT_COMMAND = "left";

	private static final String RIGHT_COMMAND = "right";

	private static final String REPORT_COMMAND = "report";

	private static Grid grid = null;

	private static boolean firstValidPlaceCommandFound = false;

	/**
	 * Invokes the toy robot application.
	 * 
	 * If there are no arguments provided with the command then the commands are
	 * read from the console.
	 * 
	 * If the first argument to the command is provided as the filename then the
	 * commands are read from the file.
	 * 
	 * If there is more than one argument provided with the command then this will
	 * output the invalid command error message.
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {

		grid = new Grid();

		if (args.length == 0) {

			// commands are read from the console
			while (true) {

				Console console = System.console();

				String command = console.readLine();

				executeCommand(command);
			}
		} else if (args.length == 1) {

			// commands are read from the file
			executeCommandsFromAFile(args[0]);
		} else {

			// Invalid command
			System.err.println("Invalid command.");
		}

	}

	/**
	 * Read and execute commands from a file.
	 * 
	 * @param inputFileName
	 *            file to read the commands from
	 */
	private static void executeCommandsFromAFile(String inputFileName) {
		List<String> commands = readFileInList(inputFileName);

		Iterator<String> commandIterator = commands.iterator();
		while (commandIterator.hasNext()) {

			executeCommand(commandIterator.next());
		}
	}

	/**
	 * Execute a single command.
	 * 
	 * @param command
	 *            command to execute
	 */
	private static void executeCommand(String command) {
		if (command.toLowerCase().startsWith(PLACE_COMMAND)) {

			// place
			try {

				// Split the place command to get the x and y value, and the face direction of
				// the toy robot.
				String[] commandOptions = command.substring(6).split(DELIMITER);

				// Remove unnecessary spaces from the x and y value and the face direction.
				int robotXValue = Integer.parseInt(commandOptions[0].replace(SPACE, EMPTY_STRING));
				int robotYValue = Integer.parseInt(commandOptions[1].replace(SPACE, EMPTY_STRING));
				String robotFaceDirection = commandOptions[2].replace(SPACE, EMPTY_STRING);

				boolean validPlaceCommand = false;

				// validate the face direction value and then place the toy robot at the given
				// position and facing the given direction.
				if (validateFaceDirection(robotFaceDirection)) {

					validPlaceCommand = grid.place(robotXValue, robotYValue, robotFaceDirection);
				}

				// Marks that the first valid place command has been executed.
				if (!firstValidPlaceCommandFound) {
					firstValidPlaceCommandFound = validPlaceCommand;
				}

			} catch (NumberFormatException nfe) {

				// skip invalid command
			} catch (ArrayIndexOutOfBoundsException ae) {

				// skip invalid command
			} catch (StringIndexOutOfBoundsException se) {

				// skip invalid command
			}

		} else if (firstValidPlaceCommandFound && command.toLowerCase().equals(MOVE_COMMAND)) {
			// move
			grid.move();

		} else if (firstValidPlaceCommandFound && command.toLowerCase().equals(LEFT_COMMAND)) {
			// left
			grid.left();

		} else if (firstValidPlaceCommandFound && command.toLowerCase().equals(RIGHT_COMMAND)) {
			// right
			grid.right();

		} else if (firstValidPlaceCommandFound && command.toLowerCase().equals(REPORT_COMMAND)) {
			// report
			grid.report();
		}
	}

	/**
	 * Validate the robot face direction value to ensure that it is one of NORTH,
	 * SOUTH, EAST or WEST.
	 * 
	 * @param robotFaceDirection
	 *            face direction of the robot.
	 * @return true if the value is one of NORTH, SOUTH, EAST or WEST.
	 */
	private static boolean validateFaceDirection(String robotFaceDirection) {

		return FaceDirectionEnum.valueOfFaceDirection(robotFaceDirection) != null;
	}

	/**
	 * Read commands from a file and store them in a list.
	 * 
	 * @param fileName
	 *            file containing the commands
	 * @return
	 */
	private static List<String> readFileInList(String fileName) {

		List<String> commands = Collections.emptyList();
		try {
			commands = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		}

		catch (IOException e) {

		}
		return commands;
	}
}

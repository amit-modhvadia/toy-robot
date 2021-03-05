/**
 * 
 */
package com.zone.toyrobot.grid;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the grid commands and constraints such not falling of the grid.
 * 
 * @author Amit Modhvadia
 *
 */
public class GridTest {

	private Grid grid = null;

	private static final String PLACE_COMMAND_REPORT_OUTPUT = "Output:0, 0, NORTH";

	private static final String LEFT_COMMAND_REPORT_OUTPUT_1 = "Output:0, 0, WEST";

	private static final Object LEFT_COMMAND_REPORT_OUTPUT_2 = "Output:0, 0, SOUTH";

	private static final Object LEFT_COMMAND_REPORT_OUTPUT_3 = "Output:0, 0, EAST";

	private static final Object LEFT_COMMAND_REPORT_OUTPUT_4 = "Output:0, 0, NORTH";

	private static final String RIGHT_COMMAND_REPORT_OUTPUT_1 = "Output:0, 0, EAST";

	private static final Object RIGHT_COMMAND_REPORT_OUTPUT_2 = "Output:0, 0, SOUTH";

	private static final Object RIGHT_COMMAND_REPORT_OUTPUT_3 = "Output:0, 0, WEST";

	private static final Object RIGHT_COMMAND_REPORT_OUTPUT_4 = "Output:0, 0, NORTH";

	private static final String MOVE_COMMAND_REPORT_OUTPUT = "Output:0, 1, NORTH";

	private static final Object REPORT_COMMAND_REPORT_OUTPUT = "Output:1, 2, WEST";

	private static final String MULTIPLE_COMMANDS_REPORT_OUTPUT_1 = "Output:0, 1, NORTH";

	private static final Object MULTIPLE_COMMANDS_REPORT_OUTPUT_2 = "Output:0, 0, WEST";

	private static final Object MULTIPLE_COMMANDS_REPORT_OUTPUT_3 = "Output:3, 3, NORTH";

	private static final Object PLACE_COMMAND_FALLING_X_AXIS_REPORT_OUTPUT_1 = "Output:1, 2, WEST";

	private static final Object PLACE_COMMAND_FALLING_Y_AXIS_REPORT_OUTPUT_1 = "Output:1, 2, WEST";

	private static final Object MOVE_COMMAND_FALLING_X_AXIS_REPORT_OUTPUT_1 = "Output:4, 1, EAST";

	private static final Object MOVE_COMMAND_FALLING_Y_AXIS_REPORT_OUTPUT_1 = "Output:1, 4, NORTH";

	private static final Object PLACE_COMMAND_FALLING_X_AXIS_REPORT_OUTPUT_2 = "Output:1, 2, WEST";

	private static final Object PLACE_COMMAND_FALLING_Y_AXIS_REPORT_OUTPUT_2 = "Output:1, 2, WEST";

	private static final Object MOVE_COMMAND_FALLING_X_AXIS_REPORT_OUTPUT_2 = "Output:0, 1, WEST";

	private static final Object MOVE_COMMAND_FALLING_Y_AXIS_REPORT_OUTPUT_2 = "Output:1, 0, SOUTH";

	/**
	 * Set up the test.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		grid = new Grid();
	}

	/**
	 * Handle the test completing.
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

		grid = null;
	}

	/**
	 * Test the place command.
	 */
	@Test
	public void testPlaceCommand() {

		grid.place(0, 0, "NORTH");

		assertEquals(PLACE_COMMAND_REPORT_OUTPUT, grid.report());
	}

	/**
	 * Test the left command.
	 */
	@Test
	public void testLeftCommand() {

		grid.place(0, 0, "NORTH");
		grid.left();

		assertEquals(LEFT_COMMAND_REPORT_OUTPUT_1, grid.report());

		grid.left();

		assertEquals(LEFT_COMMAND_REPORT_OUTPUT_2, grid.report());

		grid.left();

		assertEquals(LEFT_COMMAND_REPORT_OUTPUT_3, grid.report());

		grid.left();

		assertEquals(LEFT_COMMAND_REPORT_OUTPUT_4, grid.report());

	}

	/**
	 * Test the right command.
	 */
	@Test
	public void testRightCommand() {

		grid.place(0, 0, "NORTH");
		grid.right();

		assertEquals(RIGHT_COMMAND_REPORT_OUTPUT_1, grid.report());

		grid.right();

		assertEquals(RIGHT_COMMAND_REPORT_OUTPUT_2, grid.report());

		grid.right();

		assertEquals(RIGHT_COMMAND_REPORT_OUTPUT_3, grid.report());

		grid.right();

		assertEquals(RIGHT_COMMAND_REPORT_OUTPUT_4, grid.report());
	}

	/**
	 * Test the move command.
	 */
	@Test
	public void testMoveCommand() {

		grid.place(0, 0, "NORTH");
		grid.move();

		assertEquals(MOVE_COMMAND_REPORT_OUTPUT, grid.report());
	}

	/**
	 * Test the report command.
	 */
	@Test
	public void testReportCommand() {

		grid.place(1, 2, "WEST");

		assertEquals(REPORT_COMMAND_REPORT_OUTPUT, grid.report());
	}

	/**
	 * Test multiple commands on a grid.
	 */
	@Test
	public void testMultipleCommands() {

		grid.place(0, 0, "NORTH");
		grid.move();

		assertEquals(MULTIPLE_COMMANDS_REPORT_OUTPUT_1, grid.report());

		grid.place(0, 0, "NORTH");
		grid.left();

		assertEquals(MULTIPLE_COMMANDS_REPORT_OUTPUT_2, grid.report());

		grid.place(1, 2, "EAST");
		grid.move();
		grid.move();
		grid.left();
		grid.move();

		assertEquals(MULTIPLE_COMMANDS_REPORT_OUTPUT_3, grid.report());
	}

	/**
	 * Test the scenario where the place commands puts the toy robot off the grid.
	 */
	@Test
	public void testPlaceCommandFallingScenario() {

		grid.place(1, 2, "WEST");
		grid.place(5, 2, "NORTH");

		assertEquals(PLACE_COMMAND_FALLING_X_AXIS_REPORT_OUTPUT_1, grid.report());

		grid.place(1, 2, "WEST");
		grid.place(1, 5, "NORTH");

		assertEquals(PLACE_COMMAND_FALLING_Y_AXIS_REPORT_OUTPUT_1, grid.report());

		grid.place(1, 2, "WEST");
		grid.place(-1, 2, "NORTH");

		assertEquals(PLACE_COMMAND_FALLING_X_AXIS_REPORT_OUTPUT_2, grid.report());

		grid.place(1, 2, "WEST");
		grid.place(1, -1, "NORTH");

		assertEquals(PLACE_COMMAND_FALLING_Y_AXIS_REPORT_OUTPUT_2, grid.report());

	}

	/**
	 * Test the scenario where the move command puts the toy robot off the grid.
	 */
	@Test
	public void testMoveCommandFallingScenario() {

		grid.place(4, 1, "EAST");
		grid.move();

		assertEquals(MOVE_COMMAND_FALLING_X_AXIS_REPORT_OUTPUT_1, grid.report());

		grid.place(1, 4, "NORTH");
		grid.move();

		assertEquals(MOVE_COMMAND_FALLING_Y_AXIS_REPORT_OUTPUT_1, grid.report());

		grid.place(0, 1, "WEST");
		grid.move();

		assertEquals(MOVE_COMMAND_FALLING_X_AXIS_REPORT_OUTPUT_2, grid.report());

		grid.place(1, 0, "SOUTH");
		grid.move();

		assertEquals(MOVE_COMMAND_FALLING_Y_AXIS_REPORT_OUTPUT_2, grid.report());

	}

}

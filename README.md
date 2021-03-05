# Toy Robot

Toy Robot can be placed and moved on table top a 5 x 5 unit grid. The toy robot does not fall off from the table top and the robot is free obstuction to roam around the table top.

# Build, test and run the application locally

1.	Pull the code from this repository to your local directory.
2.	Navigate to your local directory.
3.	In the command prompt, run command (mvn clean install) to build the application. You will see the BUILD SUCCESS output from Maven. Now you are ready to start the application. 
4.	In the command prompt, run command (java -cp target\toy-robot-1.0.jar com.zone.toyrobot.ToyRobotApp) on Windows. This will run the toy robot application and the commands will be entered in the command prompt.
5.	In the command prompt, run command (java -cp target\toy-robot-1.0.jar com.zone.toyrobot.ToyRobotApp src\test\resources\commands.txt) on Windows. This will run the toy robot with commands from the commands.txt file.

## Toy Robot Commands

The commands that can be issued to the robot on the command prompt after the toy robot application is running. Only in console mode.

### PLACE X,Y,FACING
Puts the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST.

### MOVE
Moves the toy robot one unit forward in the direction it is currently facing.

### LEFT
Will rotate the robot 90 degrees anticlockwise without changing the position of the robot.

### RIGHT
Rotate the robot 90 degrees clockwise without changing the position of the robot.

### REPORT
Outputs the X,Y and Face direction of the robot. 
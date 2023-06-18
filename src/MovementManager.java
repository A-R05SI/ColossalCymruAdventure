/**
 * Class to manage the movement of the player within the game
 * <br>
 * Methods included are:
 * <pre>movePlayer:	Returns the coordinate of the player and a notification message 
 * 					after a valid or invalid move action.</pre>
 * 
 * @author Stuart Gadd
 * @version 0.1 - 	Initial draft of Movement method <br>
 * @version 0.2 - 	Added error checking, constant variables and renamed class to be
 * 					in-line with project naming convention <br>
 * @version 0.3 - 	Changed movePlayer and constant variables to static as there is no
 * 					need to create a MovementManager object. <br>
 * @since 2023/06/16
 * 
 */
public class MovementManager {

	//Variable Declaration
	private static final int MIN_COORDINATE = 0;	//Minimum coordinate possible in the game.
	private static final int MAX_COORDINATE = 4;	//Maximum coordinate possible in the game.
	
    /**
     * Default empty constructor as an object does not need to be created to use the methods.
     * 
     */
	public MovementManager() {
	}
	
	/**
	 * Method to check if move is valid and update coordinate of player accordingly. <br>
	 * Static method as no need to create an object to process a move action.
	 * 
	 * @param coordinate	current coordinate of the player based on the direction chosen.
	 * @param direction		direction the player has chosen to move in.
	 * @return int -		current coordinate if invalid move otherwise updated coordinate of
	 * 						player. <br><br>
	 * 
	 * Has a side affect of changing the global variable playerX or playerY. <br>
	 * Is referentially transparent.
	 * 
	 */
	public static int movePlayer(int coordinate, String direction) {
		
		//Switch case to validate direction being actioned and update player coordinate accordingly.
		switch (direction) {
			case "n":
				//Check if player is at the boundary of the game grid.
				if (coordinate <= MIN_COORDINATE) {
					System.out.println("Can't go north!\n");
				//Check if player is beyond the boundary of the game grid.
				} else if (coordinate > MAX_COORDINATE){
					System.out.println("FATAL ERROR DURING MOVING NORTH ACTION: Player is outside boundary of game!!! PlayerY coordinate is " + coordinate);
					System.exit(0);		//Terminate program as something has gone fatally wrong.
				//If valid move update coordinate and notify player.
				} else {
					System.out.println("You have travelled north.\n");
					coordinate--;
				}
				break;
			case "s":
				//Check if player is at the boundary of the game grid.
				if (coordinate >= MAX_COORDINATE) {
					System.out.println("Can't go south!\n");
				//Check if player is beyond the boundary of the game grid.
				} else if (coordinate < MIN_COORDINATE){
					System.out.println("FATAL ERROR DURING MOVING SOUTH ACTION: Player is outside boundary of game!!! PlayerY coordinate is " + coordinate);
					System.exit(0); 	//Terminate program as something has gone fatally wrong.
				//If valid move update coordinate and notify player.
				} else {
					System.out.println("You have travelled south.\n");
					coordinate++;
				}
				break;
			case "w":
				//Check if player is at the boundary of the game grid.
				if (coordinate <= MIN_COORDINATE) {
					System.out.println("Can't go west!\n");
				//Check if player is beyond the boundary of the game grid.
				} else if (coordinate > MAX_COORDINATE){
					System.out.println("FATAL ERROR DURING MOVING WEST ACTION: Player is outside boundary of game!!! PlayerX coordinate is " + coordinate);
					System.exit(0);		//Terminate program as something has gone fatally wrong.
				//If valid move update coordinate and notify player.
				} else {
					System.out.println("You have travelled west.\n");
					coordinate--;
				}
				break;
			case "e":
				//Check if player is at the boundary of the game grid.
				if (coordinate >= MAX_COORDINATE) {
					System.out.println("Can't go east!\n");
				//Check if player is beyond the boundary of the game grid.
				} else if (coordinate < MIN_COORDINATE){
					System.out.println("FATAL ERROR DURING MOVING EAST ACTION: Player is outside boundary of game!!! PlayerX coordinate is " + coordinate);
					System.exit(0);		//Terminate program as something has gone fatally wrong.
				//If valid move update coordinate and notify player.
				} else {
					System.out.println("You have travelled east.\n");
					coordinate++;
				}
				break;
			default:
				System.out.println("Unknown move action detected - You have not been moved, please try again.\n");
		}
	
		return coordinate;
	}	
}

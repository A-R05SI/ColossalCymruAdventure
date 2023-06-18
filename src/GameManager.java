/**
 * This file contains classes relevant to managing the gameplay of the program.
 */

import java.util.Scanner;

/**
 * This class describes a GameManager, the class responsible for dictating the flow of gameplay.
 * This class allows a player to navigate the map, initiate battles, and use items.
 * @author jackroberts
 *
 */
public class GameManager {
	
	public final static Map GAME_MAP = new Map(); //Create new map for entire game.
	private static int playerX = 0; //Tracks x coord of player. player starts in top left
	private static int playerY = 0; //tracks y coord of player. player starts in top left
	
	/**
	 * Initialises a game and provides main gameplay loop.
	 */
	public static void beginGame() {
		
		boolean returnToMainMenu = false; //Allow exit of game loop.
		
		Scanner actionScanner = new Scanner(System.in);
		
		//Game Loop until decision is reached to return to main menu.
		while (!returnToMainMenu) {
			
			//First step is to describe where the player is.
			System.out.println(GAME_MAP.getDescription(playerX, playerY));
			
			//Get whether or not there is a monster at current location.
			Actor monsterAtLocation = GAME_MAP.getMonsterAt(playerX, playerY);
			//If there is a monster present, inform the player as to what the monster is called.
			if (monsterAtLocation != null) {
				System.out.println("There is a monster here."
						+ " I'd output its name if my code were finished.");
			}
			
			System.out.println("What now?\n"); //Prompt for user input.
		
			String actionChoice = actionScanner.nextLine();
			
			//Switches based on user choice.
			switch (actionChoice) {
				case "n":
					//TODO move north and update player location if valid move.
					System.out.println("WARNING - Feature Unimplemented");
					break;
				case "e":
					//TODO move east and update player location if valid move.
					System.out.println("WARNING - Feature Unimplemented");
					break;
				case "s":
					//TODO move south and update player location if valid move.
					System.out.println("WARNING - Feature Unimplemented");
					break;
				case "w":
					//TODO move west and update player location if valid move.
					System.out.println("WARNING - Feature Unimplemented");
					break;
				case "use":
					//Handle player using an item.
					beginUse();
					break;
				case "attack":
					//Handle player attacking a monster.
					beginBattle();
					break;
				case "quit":
					//Allow a user to return to main menu.
					returnToMainMenu = true;
					break;
				default:
					//Handle unexpected inputs.
					System.out.println("I'm not sure what you're asking. Please rephrase.");
			}
		}
		actionScanner.close();
	}
	
	/**
	 * Begins a battle if a monster is present.
	 */
	private static void beginBattle() {
		
		if (GAME_MAP.getMonsterAt(playerX, playerY) != null) {
			//TODO call BattleManager.
			Actor player = null;
			Actor monster = null;
			BattleManager battle = new BattleManager(player, monster);
			
		} else {
			System.out.println("There's no monster to battle!");
		}
	}
	
	/**
	 * Begins option to use items.
	 */
	private static void beginUse() {
		System.out.println("WARNING - Feature Unimplemented");
		//TODO Handle using items if the player has them.
	}
	

}

/**
 * This file contains classes relevant to managing the gameplay of the program.
 */

import java.util.Scanner;
import java.util.List;
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
			System.out.println("WARNING - Feature Unimplemented");
			
		} else {
			System.out.println("There's no monster to battle!");
			System.out.println("WARNING - Feature Unimplemented");
		}
	}
	
	/**
	 * Begins option to use items.
	 */
	private static void beginUse() {
		Scanner scanner = new Scanner(System.in);
        
        System.out.println("Inventory:");
        for (Item item : inventory) {
            System.out.println(item.getitemName());
        }
        
        System.out.println("Choose an item from the inventory: ");
        String chosenItem = scanner.nextLine();
        
        Item itemToUse = null;
        for (Item item : inventory) {
            if (item.getitemName().equals(chosenItem)) {
                itemToUse = item;
                break;
            }
        }
        
        if (itemToUse != null) {
            String itemName = itemToUse.getitemName();
            
            if (itemName.equals("Sword")) {
                System.out.println("Can't use that here!");
            } else if (itemName.equals("Potion")) {
                health += 20;
                System.out.println("You take a swig of potion.");
            } else if (itemName.equals("Bara Brith")) {
                health += 50;
                System.out.println("The taste of childhood rejuvenates you.");
            } else if (itemName.equals("Textbook")) {
                experience += 75;
                System.out.println("Your newfound knowledge of Discrete Maths emboldens you.");
            } else if (itemName.equals("Spear")) {
                System.out.println("Can't use that here!");
            } else if (itemName.equals("Phone")) {
                if (gold > 10) {
                    gold -= 10;
                    experience += 100;
                    System.out.println("You call in some help.");
                } else {
                    System.out.println("You don't have enough gold to use the phone.");
                }
            }
            
            if (itemName.equals("Sword") || itemName.equals("Spear")) {
                currentWeapon = itemToUse;
                System.out.println("You equipped the " + itemName + ".");
            }
            
            inventory.remove(itemToUse);
        } else {
            System.out.println("Item not found in inventory.");
        }
    }
	}

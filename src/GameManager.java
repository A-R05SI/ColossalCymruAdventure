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
	Player player = new Player("Player"); // Create an instance of Player;
	
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
					//Call to update coordinate of player if a valid move, otherwise
					//display invalid move message.
					playerY = MovementManager.movePlayer(playerY, actionChoice);
					break;
				case "e":
					//Call to update coordinate of player if a valid move, otherwise
					//display invalid move message.
					playerX = MovementManager.movePlayer(playerX, actionChoice);
					break;
				case "s":
					//Call to update coordinate of player if a valid move, otherwise
					//display invalid move message.
					playerY = MovementManager.movePlayer(playerY, actionChoice);
					break;
				case "w":
					//Call to update coordinate of player if a valid move, otherwise
					//display invalid move message.
					playerX = MovementManager.movePlayer(playerX, actionChoice);
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
	 * Allows selection and use of items from the
	 * inventory.
	 * 
	 * side-effects
	 * not rerentially transparent
	 */
	private static void beginUse() {
		Scanner scanner = new Scanner(System.in);


    	List<Item> inventory = player.getInventory(); // Access the inventory through the Player instance

		// Display inventory
        System.out.println("Inventory:");
        for (Item item : inventory) {
            System.out.println(item.getitemType());
        }
        
        System.out.println("Choose an item from the inventory: ");
        String chosenItem = scanner.nextLine();
        
        Item itemToUse = null;
        for (Item item : inventory) {
            if (item.getitemType().equals(chosenItem)) {
                itemToUse = item;
                break;
            }
        }
        
        if (itemToUse != null) {
            String itemType = itemToUse.getitemType();

             // Use sword item
            if (itemType.equals("Sword")) {
                System.out.println("Can't use that here!");
				// Use potion item
            } else if (itemType.equals("Potion")) {
                player.setHealth(+20);
                System.out.println("You take a swig of potion.");
				// Use Bara Brith item
            } else if (itemType.equals("Bara Brith")) {
                player.setHealth(+50);
                System.out.println("The taste of childhood rejuvenates you.");
				// Use Textbook item
            } else if (itemType.equals("Textbook")) {
                player.addExperience(75);
                System.out.println("Your newfound knowledge of Discrete Maths emboldens you.");
				// Use Spear item
            } else if (itemType.equals("Spear")) {
                System.out.println("Can't use that here!");
				// Use Phone item
            } else if (itemType.equals("Phone")) {
				// Use Phone item if enough gold.
                if (player.getGold() > 10) {
                    player.addGold(10);
                    player.addExperience(100);
                    System.out.println("You call in some help.");
                } else {
					// Display lack of gold for phone message
                    System.out.println("You don't have enough gold to use the phone.");
                }
            }
            // Equip weapon if it is a sword or spear
            if (itemType.equals("Sword") || itemType.equals("Spear")) {
                player.setCurrentWeapon(itemToUse);
                System.out.println("You equipped the " + itemType + ".");
            }
             // Remove used item from the inventory
            inventory.remove(itemToUse);
        } else {
            System.out.println("Item not found in inventory.");
        }
    }
	}

/**
 * This class describes a collectible item rewarded after every battle.
 * 
 * @author Liam O'Connor
 * @version 1
 */

import java.util.Random;

public class Item {
    private String itemType;
    private int goldCost;
    private int damage;

     private static final String[] WEAPONS = {"Sword", "Spear"};
     private static final String[] USEFUL_ITEMS = {"Potion", "Bara Brith", "Textbook", "Phone"};


   /**
     * Constructs an Item object with a random item type and gold cost.
     */
    public Item() {
        Random random = new Random();
        int weaponIndex = random.nextInt(WEAPONS.length);
        int usefulItemIndex = random.nextInt(USEFUL_ITEMS.length);

        if (weaponIndex == 0) { // Sword
            this.itemType = WEAPONS[weaponIndex];
            this.damage = 10; // Assign a default damage value for Sword
        } else if (weaponIndex == 1) { // Spear
            this.itemType = WEAPONS[weaponIndex];
            this.damage = 8; // Assign a default damage value for Spear
        } else {
            this.itemType = USEFUL_ITEMS[usefulItemIndex];
            this.damage = 0; // Set damage to 0 for useful items
        }

        if (this.itemType.equals("Phone")) {
            this.goldCost = 10;
        } else {
            this.goldCost = 0;
        }
    }

    /**
     * Constructs an Item object with the given item type, gold cost, and damage value.
     * 
     * @param itemType The type of the item.
     * @param goldCost The gold cost of the item.
     * @param damage   The damage value of the item (applicable to weapons).
     */
    public Item(String itemType, int goldCost, int damage) {
        this.itemType = itemType;
        this.goldCost = goldCost;
        this.damage = damage;
    }

    /**
     * Returns the type of the item.
     * 
     * @return The Type of the item.
     */
    public String getitemType() {
        return itemType;
    }

    /**
     * Returns the gold cost of the item.
     * 
     * @return The gold cost of the item.
     */
    public int getGoldCost() {
        return goldCost;
    }

     /**
     * Returns the damage value of the item.
     * 
     * @return The damage value of the item.
     */
    public int getDamage() {
        return damage;
    }

}
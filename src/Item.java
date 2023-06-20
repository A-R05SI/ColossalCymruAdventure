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

    private static final String[] ITEM_TYPES = {"Sword", "Potion", "Bara Brith", "Textbook", "Spear", "Phone"};

    /**
     * 
     * Constructs an Item object with the given name and gold cost.
     * 
     * @param itemType The type of the item.
     * @param goldCost The gold cost of the item.
     */
    public Item(String itemType, int goldCost) {
        Random random = new Random();
        int index = random.nextInt(ITEM_TYPES.length);
        this.itemType = ITEM_TYPES[index];
        if (this.itemType.equals("Phone")) {
            this.goldCost = 10;
        } else {
            this.goldCost = 0;
        }
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

}
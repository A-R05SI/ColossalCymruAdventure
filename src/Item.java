/**
 * This class describes a collectible item rewarded after every battle.
 * 
 * @author Liam O'Connor
 * @version 0.2
 */

public class Item {
    private String itemType;
    private int goldCost;

    /**
     * 
     * Constructs an Item object with the given name and gold cost.
     * 
     * @param itemType The type of the item.
     * @param goldCost The gold cost of the item.
     */
    public Item(String itemType, int goldCost) {
        this.itemType = itemType;
        this.goldCost = goldCost;
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
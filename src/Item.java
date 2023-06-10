/**
 * This class describes a collectible item rewarded after every battle.
 * @author Liam O'Connor
 *
 */

public class Item {
    private String itemType;
    private int goldCost;
    
    public Item(String itemType, int goldCost) {
        this.itemType = itemType;
        this.goldCost = goldCost;
    }
    
    public String getItemType() {
        return itemType;
    }
    
    public int getGoldCost() {
        return goldCost;
    }
}
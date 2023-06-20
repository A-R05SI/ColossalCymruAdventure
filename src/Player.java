/**
 * This class describes a Player.
 *
 * @author lowriholborow
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player extends Actor {

    final int MIN_GOLD = 0;
    final int MAX_GOLD = 9999999;
    final int MIN_EXPERIENCE = 0;
    final int STARTER_SWORD_DAMAGE = 5;

    int experience = MIN_EXPERIENCE;
    int gold = MIN_GOLD;

    List<Item> inventory = new ArrayList<Item>();
    Item currentWeapon;

    /**
     * Constructor for Player
     */
    public Player(String name) {
        super(name);
        Item starter_sword = new Item("Sword", 0, STARTER_SWORD_DAMAGE);
        setCurrentWeapon(starter_sword);
    }

    // Getters and Setters
    /**
     * Returns the experience for this Player
     *
     * @return the experience for this Player
     */

    int getExperience() {
        return experience;
    }

    /**
     * Sets and calculates the experience of this Player
     */

    void addExperience(int gainedXP) {
        //experience = gainedXP if 0 ≤ level ≤ 100
        this.level += gainedXP;

        // Once the Level has reached its maximum, the player gets 100 gold instead of experience.
        if (this.level >= MAX_LEVEL) {
            addGold(100);
            return;
        }

        // When the player gathers enough Experience, their Level increases by 1.
        if (this.experience > 3 * (this.level * 0.1) + 10) {
            setLevel(this.level + 1);
            return;
        }
    }

    /**
     * Get and manage the Player's items
     */

    public List<Item> getInventory() {
        return Collections.unmodifiableList(inventory);
    }

    void addToInventory(Item item) {
        inventory.add(item);
    }

    void removeFromInventory(Item item) {
        inventory.remove(item);
    }

    /**
     * Returns the gold amount for this Player
     *
     * @return the gold amount for this Player
     */

    int getGold() {
        return gold;
    }

    //Don't add more gold if at max
    void addGold(int gold) {
        if (gold >= MAX_GOLD) {
            return;
        }
    //Add gold to the Player
        this.gold += gold;
    }

    /**
     * Returns the current weapon for this Player
     *
     * @return the current weapon for this Player
     */

    Item getCurrentWeapon() {
        return currentWeapon;
    }

    /**
     * Sets the current weapon for this Player
     */

    void setCurrentWeapon(Item newCurrentWeapon) {
        this.currentWeapon = newCurrentWeapon;
    }
}




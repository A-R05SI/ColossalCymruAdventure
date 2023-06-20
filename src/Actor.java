/**
 * This class describes an Actor: a character in the game.
 *
 * @author lowriholborow
 */
public abstract class Actor {

    final int MIN_LEVEL = 0;
    final int MAX_LEVEL = 100;
    final int MIN_ARMOUR = 0;
    final int MAX_HEALTH = 100;

    String name;

    int level = MIN_LEVEL;
    int armour = 0;
    int health = MAX_HEALTH;

    /**
     * Constructor for Actor
     */
    public Actor(String name) {
        this.name = name;
    }
    // Getters and Setters
    /**
     * Sets the level of this Actor
     */
    void setLevel(int newLevel) {
        int level = newLevel;

        if (level >= MAX_LEVEL) {
            level = MAX_LEVEL;
        } else if (level < MIN_LEVEL) {
            level = MIN_LEVEL;
        }

        this.level = level;
    }

    /**
     * Returns the level of this Actor
     *
     * @return the level of the Actor
     */
    int getLevel() {
        return level;
    }

    /**
     * Sets the name of this Actor
     */
    void setName(String newName) {
        this.name = newName;
    }

    /**
     * Returns the name of this Actor
     *
     * @return the name of the Actor
     */

    String getName() {
        return name;
    }

    /**
     * Sets the armour of this Actor
     */

    void setArmour(int newArmour) {
        int armour = newArmour;

        if (armour < MIN_ARMOUR) {
            armour = 0;
        } else if (armour > 0) {
            int maximumArmour = Math.max(level, MIN_LEVEL) / 2;
            armour = armour > maximumArmour ? maximumArmour : armour;
        }

        this.armour = armour;
    }

    /**
     * Returns the armour of this Actor
     *
     * @return the armour of the Actor
     */

    int getArmour() {
        return armour;
    }

    /**
     * Sets the health of this Actor
     */

    void setHealth(int newHealth) {
        int health = newHealth;

        if (health > MAX_HEALTH) {
            health = MAX_HEALTH;
        }

        this.health = health;
    }

    /**
     * Returns the health of this Actor
     *
     * @return the health of the Actor
     */

    int getHealth() {
        return health;
    }
}




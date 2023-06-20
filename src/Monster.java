/**
 * This class describes a Monster.
 *
 * @author lowriholborow
 *
 */

public class Monster extends Actor {
    Item loot;

    /**
     * Constructor for Monster
     */
    public Monster(String name) {
        super(name);

        // Ensure random
        loot = new Item();
    }
}

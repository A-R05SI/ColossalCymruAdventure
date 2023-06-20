import java.util.Random;

/**
 * A class decribing BattleManager - a class to handle Battle gameplay.
 * @author jackroberts
 *
 */
public class BattleManager {

    Random random = new Random();
    Player player = null;
    Monster monster = null;
    Boolean isPlayerTurn = false; // starts off false but changes when startBattle is run.

    public BattleManager(Player Player, Monster Monster){
        this.player = Player;
        this.monster = Monster;
        startBattle();
    }

    private void startBattle(){
        final int PLAYER_XP_IF_WIN = 100;
        final int PLAYER_GOLD_IF_WIN = 5;
        while(!is_battle_over()) {
            isPlayerTurn = !isPlayerTurn; // In first run, allows for player to go first
            if (isPlayerTurn){
                playerAttack();
            } else {
                monsterAttack();
            }
        }
        if (isPlayerTurn){
            System.out.println(player.getName() + " has died.");
            System.out.println("Game Over.");
            System.exit(0);
        } else {
            System.out.printf("%s has been killed.\n", monster.getName());
            System.out.printf("%s has won the battle.\n", player.getName());

            player.addExperience(PLAYER_XP_IF_WIN);
            player.addGold(PLAYER_GOLD_IF_WIN);
            player.addToInventory(monster.loot);
        }
    }

    private void playerAttack(){
        int attack = player.getCurrentWeapon().getDamage();
        int ac = monster.getArmour();
        if(attack == 0){
            System.out.printf("%s missed.\n", player.getName());
        } else if (attack <= ac){
            System.out.printf("%s struck a glancing blow!\n", player.getName());
        } else {
            int damageDealt = attack - ac;
            monster.setHealth(monster.getHealth() - damageDealt);
            System.out.printf("%s landed a hit for %s damage!\n", player.getName(), damageDealt);
        }
    }

    private void monsterAttack(){
        final int MAXIMUM_ATTACK = 20;
        Random random = new Random();
        int attack = random.nextInt(MAXIMUM_ATTACK + 1); //allows for attacks == MAXIMUM_ATTACK
        int ac = player.getArmour();
        if(attack == 0){
            System.out.printf("%s missed.\n", monster.getName());
        } else if (attack <= ac){
            System.out.printf("%s struck a glancing blow!\n", monster.getName());
        } else {
            int damageDealt = attack - ac;
            player.setHealth(player.getHealth() - damageDealt);
            System.out.printf("%s landed a hit for %s damage!\n", monster.getName(), damageDealt);
        }
    }

    private boolean is_battle_over(){
        if((player.getHealth() > 0) && (monster.getHealth() > 0)){
            return false;
        } else {
            return true;
        }
    }
}

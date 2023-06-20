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

        while(!is_battle_over()) {
            isPlayerTurn = !isPlayerTurn; // In first run, allows for player to go first
            if (isPlayerTurn){
                playerAttack();
            } else {
                monsterAttack();
            }
        }
        if (isPlayerTurn){
            System.out.println(this.player.getName() + " has died.");
            System.out.println("Game Over.");
            System.exit(0);
        }
    }

    private void playerAttack(){
        
    }

    private void monsterAttack(){
        final int MAXIMUM_ATTACK = 20;
        Random random = new Random();
        int attack = random.nextInt(MAXIMUM_ATTACK + 1); //allows for attacks == MAXIMUM_ATTACK
        float ac = this.player.getArmour();
        
    }

    private boolean is_battle_over(){
        if((this.player.getHealth() > 0) && (this.monster.getHealth() > 0)){
            return false;
        } else {
            return true;
        }
    }
}

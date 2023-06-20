import java.util.Random;
/**
 * A class decribing BattleManager - a class to handle Battle gameplay.
 * @author jackroberts
 *
 */
public class BattleManager {

    Random random = new Random();

    public BattleManager(Actor Player, Actor Monster){
        this.player = player;
        this.monster = monster;
        this.isPlayerTurn = true;
    }

    private void startBattle(){

        while(!is_battle_over()) {
            if (isPlayerTurn){
                playerAttack();
            } else {
                monsterAttack();
            }
        }
    }

    private static void playerAttack(){

    }

    private static void monsterAttack(){
        final int MAXIMUM_ATTACK = 20;

        

    }

    private static boolean is_battle_over(){
        if((player.getHealth() > 0) && (monster.getHealth > 0)){
            return false
        } else {
            return true
        }
    }
}

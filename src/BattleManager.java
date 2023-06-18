import java.util.Random;
/**
 * A class decribing BattleManager - a class to handle Battle gameplay.
 * @author jackroberts
 *
 */
public class BattleManager {
    public BattleManager(Actor Player, Actor Monster){
        boolean battle_over = false;
        String turn = "player";
        while(!battle_over) {
            if (turn.equals("player")){
                playerAttack(Player, Monster);
            } else {
                monsterAttack(Player, Monster);
            }
        }
    }

    private static void playerAttack(Actor Player, Actor Monster){

    }

    private static void monsterAttack(Actor Player, Actor Monster){
        final int MINIMUM_ATTACK = 0;
        final int MAXIMUM_ATTACK = 20;
        Random random = new Random();
        
        System.out.println(random.nextInt(MAXIMUM_ATTACK));
    }
}

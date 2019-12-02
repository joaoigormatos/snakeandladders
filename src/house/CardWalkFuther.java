package house;

import player.Player;
import util.Constants;

import java.util.Random;

public class CardWalkFuther extends House implements IEffect{
    private int cardWalkFutherPosition;


    CardWalkFuther(){
        Random random = new Random();
        cardWalkFutherPosition = random.nextInt(Constants.MAX_EFFECT_CARDS) + 1;
    }


    @Override
    public boolean hasEffect() {
        return true;
    }

    @Override
    public String doEffect(Player player) {
        player.setPosition(player.getPosition()+cardWalkFutherPosition);
        return "You got a card!! \n"+ "You will walk further "+cardWalkFutherPosition + " positions";
    }
}

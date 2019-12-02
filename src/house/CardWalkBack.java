package house;

import player.Player;
import util.Constants;

import java.util.Random;

public class CardWalkBack extends House implements IEffect{
    private  int cardWalkBackPosition;
    public CardWalkBack(){
        Random random = new Random();
        cardWalkBackPosition = -1*(random.nextInt(Constants.MAX_EFFECT_CARDS) + 1);
    }



    @Override
    public boolean hasEffect() {
        return true;
    }

    @Override
    public String doEffect(Player player) {
        player.setPosition(player.getPosition() - cardWalkBackPosition);
        return "You got a card!! \n"+ "You will walk back "+cardWalkBackPosition + " positions";    }
}

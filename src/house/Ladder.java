package house;

import player.Player;

public class Ladder extends House implements IEffect{
    private int topLadderPosition;
    private int bottomLadderPosition;


    public void setTopLadderPosition(int topLadderPosition) {
        this.topLadderPosition = topLadderPosition;
    }
    public void setBottomLadderPosition(int bottomLadderPosition) {
        this.bottomLadderPosition = bottomLadderPosition;
    }


    @Override
    public boolean hasEffect() {
        return true;
    }

    @Override
    public String doEffect(Player player) {
        player.setPosition(topLadderPosition);
        return "You got luck because you crushed on a ladder! You are going to the top of the ladder \n "+ "your new position is" +
                player.getPosition();
    }
}



package house;

import player.Player;

public class Snake extends House implements IEffect {
    private int headSnakePosition;
    private int tailSnakePosition;

    public Snake() {
    }


    public  void setHeadSnakePosition(int headSnakePosition){
        this.headSnakePosition = headSnakePosition;
    }
    public void setTailSnakePosition(int tailSnakePosition){
        this.tailSnakePosition = tailSnakePosition;
    }

    @Override
    public boolean hasEffect() {
        return true;
    }

    @Override
    public String doEffect(Player player) {
        player.setPosition(tailSnakePosition);
        return "Ohhhhhh!\n"+ "You stamp on a snake so because of that you are going back to house of number: "+tailSnakePosition;
    }
}

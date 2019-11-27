package model;

public class Snake implements IEffect {
    private House headSnakePosition;
    private House tailSnakePosition;

    @Override
    public void doEffect() {

    }

    private void setHeadSnakePosition(House headSnakePosition){
        this.headSnakePosition = headSnakePosition;
    }
    private void setTailSnakePosition(House tailSnakePosition){
        this.tailSnakePosition = tailSnakePosition;
    }
}

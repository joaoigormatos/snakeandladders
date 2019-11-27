package model;

public class Ladder implements IEffect{
    private House headSnakePosition;
    private House tailSnakePosition;
    @Override
    public void doEffect() {

    }

    public House getHeadSnakePosition() {
        return headSnakePosition;
    }

    public void setHeadSnakePosition(House headSnakePosition) {
        this.headSnakePosition = headSnakePosition;
    }

    public House getTailSnakePosition() {
        return tailSnakePosition;
    }

    public void setTailSnakePosition(House tailSnakePosition) {
        this.tailSnakePosition = tailSnakePosition;
    }





}



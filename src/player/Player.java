package player;

import house.House;

public class Player {
    private int position;
    private String name;

    public Player(){ }


    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

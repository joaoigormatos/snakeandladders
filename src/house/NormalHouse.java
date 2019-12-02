package house;

import player.Player;

public class NormalHouse extends House {
    private int position;
    public NormalHouse(int position){
        this.position = position;
    }

    @Override
    public boolean hasEffect() {
        return false;
    }

    @Override
    public String doEffect(Player player) {
        return "No effect";
    }
}

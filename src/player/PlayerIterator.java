package player;

import base.Iterator;

import java.util.List;

public class PlayerIterator implements Iterator {
    private List<Player> playerList;
    private int currentIndex=0;

    public PlayerIterator(List<Player> players){
        this.playerList = players;
    }


    // In this case Always will have next because it is a circular list
    @Override
    public boolean hasNext() {
        return currentIndex < playerList.size();
    }

    @Override
    public Object next() {
        currentIndex = currentIndex == playerList.size()? 0:currentIndex;

        Player player = playerList.get(currentIndex);
        currentIndex++;

        return player;
    }
}

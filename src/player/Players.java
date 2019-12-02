package player;

import Exceptions.PlayerLimitExeception;
import base.Iterator;

import java.util.ArrayList;
import java.util.List;

public class Players implements PlayerCollection{
    public static final int MAX_PLAYERS = 4;
    public static int DEFAULT_PLAYERS =2;
    private List<Player> playersList;

    public Players(){
        playersList = new ArrayList<>();
    }


    @Override
    public Iterator createIterator() {
        return new PlayerIterator(playersList);
    }

    @Override
    public void addPlayer(String name) throws PlayerLimitExeception {
        if(playersList.size()<MAX_PLAYERS){
            Player player = new Player();
            player.setName(name);
            playersList.add(player);
        }else{
            throw new PlayerLimitExeception();
        }
    }

    @Override
    public int size() {
        return playersList.size();
    }

}

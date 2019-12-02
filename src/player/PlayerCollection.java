package player;


import Exceptions.PlayerLimitExeception;
import base.Iterator;

public interface PlayerCollection {
    Iterator createIterator();
    void addPlayer(String name) throws PlayerLimitExeception;
    int size();
}

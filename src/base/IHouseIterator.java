package base;

import Exceptions.LimitHouseException;
import house.House;

public interface IHouseIterator
{
    boolean hasNext();
    House walk(int steps, int position) ;
    boolean canWalk(int atualPosition, int steps);
    House getElement(int currentPosition);

}

package house;

import Exceptions.LimitHouseException;
import base.IHouseIterator;
import base.Iterator;
import util.Constants;

import java.util.ArrayList;
import java.util.List;

public class HouseInterator implements IHouseIterator {
    private List<House> houseList;

    public HouseInterator(List<House> houseList){
        this.houseList = houseList;
    }
    @Override
    public boolean hasNext() {
        return houseList.size() < Constants.MAX_HOUSES;
    }

    @Override
    public House walk(int steps, int  position) {
        int stepsQuantity = steps + position;
        return stepsQuantity < Constants.MAX_HOUSES? houseList.get(stepsQuantity): null;
    }


    @Override
    public boolean canWalk(int atualPosition, int steps) {
        return atualPosition + steps < Constants.MAX_HOUSES;


    }

    @Override
    public House getElement(int currentPosition) {
        return houseList.get(currentPosition);
    }


}

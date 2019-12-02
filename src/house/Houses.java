package house;

import base.IHouseIterator;
import base.Iterator;
import util.Constants;

import java.util.ArrayList;
import java.util.List;

public class Houses implements HouseCollections{

    private List<House> housesList;
    public Houses(){
        this.housesList  = new ArrayList<>();
    }

    @Override
    public IHouseIterator createIterator() {
        return new HouseInterator(housesList);
    }

    @Override
    public void addHouse(House house) {
        this.housesList.add(house);
    }

}

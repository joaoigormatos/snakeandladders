package house;

import base.IHouseIterator;

public interface HouseCollections  {
    IHouseIterator createIterator();
    void addHouse(House house);
}

package Campus;

import java.util.ArrayList;

public class Building {
  int number;
  public ArrayList<Floor> floors;
  Address address;

  //hold a number, an address, a collection of floors
  public Building(int n, Address ad) {
    number = n;
    address = ad;
    floors = new ArrayList<Floor>();
  }
  //getAddress is to retrieve the address
  public Address getAddress(){
    return address;
  }

  public Floor addNewFloor(int n) {
    Floor f = new Floor(n, this); // reference back to building;
    floors.add(f);
    return f; // return the floor you just created
  }

    // Building is safe if all floors are safe
  public Boolean isBuildingSafe() {
    for (Floor floor : floors){
      if (!floor.isFloorSafe()){ //return False if floor is not safe
        return false; // return building is not safe if that is the case
      }
    }
    return true; //return all floors are safe
  }
}

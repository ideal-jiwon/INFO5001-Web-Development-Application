package Campus;

import java.util.ArrayList;

public class Campus {
  String campusName;
  Address address;
  ArrayList<Building> buildings;

  //holding a name, an address, a collection of buildings
  public Campus(Address a, String cn) {
    campusName = cn;
    buildings = new ArrayList<Building>();
    address = a;
  }
  // addBuilding method to add buildings to the campus
  public void addBuilding(Building building){
    buildings.add(building);
  }

  //Method to check if the entire campus is safe
  public Boolean isCampusSafe() {
    for (Building building : buildings){
      if (!building.isBuildingSafe()){ //method is to return false if building is not safe
        return false; // return campus is not safe is not safe if 
      }
    }
    return true; //all buildings are safe
  }

}

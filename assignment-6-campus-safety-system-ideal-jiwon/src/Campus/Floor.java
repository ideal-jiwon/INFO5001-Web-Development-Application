package Campus;

import java.util.ArrayList;

public class Floor {

  public int number;
  ArrayList<Classroom> rooms;
  Building building;

  public Floor(int n, Building b) {
    number = n;
    building = b;
    rooms = new ArrayList<Classroom>();
  }

  public Classroom addNewClassroom(int roomnumber) {
    Classroom classroom = new Classroom(roomnumber, this); // reference back to building;
    rooms.add(classroom);
    return classroom; // return the floor you just created
  }
  // store the classrooms using getClassrooms() in FloorClass
  public ArrayList<Classroom> getClassrooms(){
    return rooms;
  }

  public Boolean isFloorSafe() { 
    for (Classroom classroom : rooms){ 
      if (!classroom.isRoomSafe()){ // check each classroom. If all classrooms are safe then floor is safe
        return false;
      }
    }
    return true;
  }
}

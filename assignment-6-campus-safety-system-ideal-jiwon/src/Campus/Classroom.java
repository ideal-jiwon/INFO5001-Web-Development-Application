package Campus;

import java.util.ArrayList;

public class Classroom {

  public int number;
  Floor floor;
  public Sprinkler sprinkler;
  ArrayList<Seat> seats;

  public Classroom(int n, Floor f) {
    number = n;
    seats = new ArrayList<Seat>();
    floor = f;
  }

  public void setSprinkler(String m, String sn) {
    sprinkler = new Sprinkler(m, sn); // used to set Sprinkler to each Classroom
  }

  public void generateSeats(int size) {
  }

  public Boolean isRoomSafe() { 
    if (sprinkler == null)
      return false;
    if (sprinkler.isActive() == true)
      return true;
    else
      return false;
  }

}

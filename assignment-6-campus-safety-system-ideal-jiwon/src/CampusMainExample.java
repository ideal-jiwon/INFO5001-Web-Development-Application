import Campus.*;

public class CampusMainExample {

  /**
   * @param args the command line arguments
   */
   public static void main(String[] args) {
    // TODO code application logic here
    /*
     * 0. Create Address object     
     * 1. create Campus object
     * 2. Create and add buildings
     * 3. Create and add floors
     * 4. Create and add rooms
     * 5. Assign sprinkers.
     * 6. Write methods to determine is campus safe => are builinds safe etc.
     */

     //0.Create address object
     Address newAddress = new Address(111,"111 Towne St", "06902", "41.04541° N, 73.53668° W");
     //1. Create campus object
     Campus newCampus = new Campus(newAddress, "Boston Campus");  
     //2. Create and add buildings
     //2-1.Create two buildings objects, each with its own address
     Building newBuilding_1 = new Building(1, new Address(1010, "Washington Blvd","06901","41.0567, -73.5387"));
     Building newBuilding_2 = new Building(2, new Address(300, "Atlantic Street","06901","41.0535, -73.5394"));
     //2-2.Retrieve unassigned address using getAddress from Building class
     Address newAddress_1 = newBuilding_1.getAddress();
     Address newAddress_2 = newBuilding_2.getAddress();
    //2-3.Add these buildings to the Campus object
     newCampus.addBuilding(newBuilding_1);
     newCampus.addBuilding(newBuilding_2);

    //3. Create and Add multiple floor object using Loop
     int numberOffloors_1 = 10;
     int numberOffloors_2 = 25;
     for (int i=1; i<= numberOffloors_1; i++){
      Floor floor = newBuilding_1.addNewFloor(i);
    //4-1. Create classrooms for each floor and add them to the appropriate floor object.
      int newClassrooms = 15;
      for (int j=1; j<=newClassrooms; j++){
          Classroom classroom = floor.addNewClassroom(j);
    //4-2. add a reference to the sprinkler system
          String m = "model :" +j;
          String sn = "Serial number :" +j;     
          classroom.setSprinkler(m, sn);
          //5. Assign Sprinklers to classrooms
          //5-1. Check if each classroom has an active sprinkler. 
          if(classroom.sprinkler != null && classroom.sprinkler.isActive()){
            System.out.println("Classroom "+classroom.number+" has an active sprinkler.");
         } else {
           System.out.println("Classroom "+classroom.number+" does not have an active sprinkler.");
         }
    }
     }

     for (int i=1; i<= numberOffloors_2; i++){
      Floor floor = newBuilding_2.addNewFloor(i);
      //4-1. Create classrooms for each floor and add them to the appropriate floor object.
      int newClassrooms = 20;
      for (int j=1; j<=newClassrooms; j++){
          Classroom classroom = floor.addNewClassroom(j);
      //4-2. add a reference to the sprinkler system
          String m = "model : "+j;
          String sn = "seral number :"+j;
          classroom.setSprinkler(m, sn);
          //5. Assign Sprinklers to classrooms
          //5-1. Check if each classroom has an active sprinkler. 
          if(classroom.sprinkler != null && classroom.sprinkler.isActive()){
             System.out.println("Classroom "+classroom.number+" has an active sprinkler.");
          } else {
            System.out.println("Classroom "+classroom.number+" does not have an active sprinkler.");
          }
      }
     }
     //6. Implement safety logic
     //6.1 Safety Logic 1 - if a class room is safe based on its sprinkler status
    for (Floor floor : newBuilding_1.floors){
     for (Classroom classroom : floor.getClassrooms()){
        int n = classroom.number;
        if(classroom.isRoomSafe()){
            System.out.println("Classroom "+ n + " is safe with an active sprinkler.");
        } else {
            System.out.println("Classroom "+ n+" is not safe. Sprinkler Inspection is required.");
        }
      }
    }  
     //6.2 Safety Logic 2 - if a floor is safe by checking all classrooms.
    System.out.println("Safety Logic comfirmation -----------------");
    System.out.println("Safety status of each floor through inspection on classrooms : ");
    for (Floor floor : newBuilding_1.floors){
      System.out.println("Floor of building 1 : " + floor.number + " is" + (floor.isFloorSafe()? " safe" : " not safe"));
    }
    for (Floor floor : newBuilding_2.floors){
      System.out.println("Floor of building 2 : " + floor.number + " is" + (floor.isFloorSafe()? " safe" : " not safe"));
    } 
    
    //6.3 Safety Logic 3 - if the campus is safe by checking all buildings
    System.out.println("Building 1 safety status : " + (newBuilding_1.isBuildingSafe()?" safe" : " not safe"));
    System.out.println("Building 2 safety status : " + (newBuilding_2.isBuildingSafe()?" safe" : " not safe"));

    System.out.println("Overall campus safety status : " + (newCampus.isCampusSafe()?"safe" : " not safe"));
   }
 }
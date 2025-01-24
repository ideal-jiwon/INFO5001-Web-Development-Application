package model;
import java.util.ArrayList;

public class Stock {
  private ArrayList<Car> carStock;
  private int year;

  public Stock(int y) {
    year = y;
    carStock = new ArrayList<Car>();
  }

  public void addcarStock(Car car){
    carStock.add(car);
  }

  public Car addNewCar(String VIN,String exteriorColor,String interiorColor,
    String manufacturer,String modelName, String bodyType, String fuelType,
    String drivetrain,String transmission,String location,int doors,
    float price,int year,int mileage,boolean isUsed,boolean isdamaged){
      
      Car newCar = new Car(VIN, exteriorColor,interiorColor,manufacturer,modelName,bodyType,fuelType,drivetrain,
      transmission,location,doors,price,year,mileage);

      carStock.add(newCar);
      return newCar;
  }
    public Car findCarbyVIN (String VIN){
        for (Car car : carStock){
          if (car.getVIN().equalsIgnoreCase(VIN)){
            return car;
          }
        }
      return null;
  }
    public Car findCarByModelMake(String modelName, String manufacturer){
      for (Car car : carStock){
        if (car.getmodelName().equalsIgnoreCase(modelName)&&
            car.getmanufacturer().equalsIgnoreCase(manufacturer)){
              return car;
            }
      }
      return null;
    }

    public void printCarInventory(){
      System.out.println("Car Inventory Information for the year of " + year);
      System.out.println("----------------------------------------");
      for (Car carInventory : carStock) {
        carInventory.printCarInfo();
        System.out.println("----------------------------------------");
    }
  }
}

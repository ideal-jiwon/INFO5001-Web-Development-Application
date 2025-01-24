package model;

//import java.lang.Runtime.Version;

public class Car {

  private String VIN;
  private String exteriorColor;
  private String interiorColor;
  private String manufacturer;
  private String modelName;
  private String bodyType;
  private String fuelType;
  private String drivetrain;
  private String transmission;
  private String location;
  private int doors;
  private float price;
  private int year;
  private int mileage;

  boolean isUsed;
  boolean isbeenAcct;

  public Car(String VIN, String exteriorColor, String interiorColor, String manufacturer, String modelName,
  String bodyType, String fuelType, String drivetrain, String transmission, String location, int doors,
  float price, int year, int mileage) {
    this.VIN = VIN;
    this.exteriorColor = exteriorColor;
    this.interiorColor = interiorColor;
    this.manufacturer = manufacturer;
    this.modelName = modelName;
    this.bodyType = bodyType;
    this.fuelType = fuelType;
    this.drivetrain = drivetrain;
    this.transmission = transmission;
    this.location = location;
    this.doors = doors;
    this.price = price;
    this.year = year;
    this.mileage = mileage;
  }

  public String getVIN() {
    return VIN;
  }
  public void setVIN(String VIN) {
    this.VIN = VIN;
  }
  public String getexteriorColor() {
    return exteriorColor;
  }
  public void setexteriorColor(String exteriorColor) {
    this.exteriorColor = exteriorColor;
  } 
  public String getmanufacturer() {
    return manufacturer;
  }
  public void setmanufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }
  public String getmodelName() {
    return modelName;
  }
  public void setmodelName(String modelName) {
    this.modelName = modelName;
  }
  public String getbodyType() {
    return bodyType;
  }
  public void setbodyType(String bodyType) {
    this.bodyType = bodyType;
  }
  public String getfuelType() {
    return fuelType;
  }
  public void setfuelType(String fuelType) {
    this.fuelType = fuelType;
  }
  public String getdrivetrain() {
    return drivetrain;
  }
  public void setdrivetrain(String drivetrain) {
    this.drivetrain = drivetrain;
  }
  public String gettransmission() {
    return transmission;
  }
  public void settransmission(String transmission) {
    this.transmission = transmission;
  }
  public String getlocation(){
    return location;
  }  
  public void setlocation(String location){
    this.location = location;
  }
  public int getdoors(){
    return doors;
  }
  public void setdoors(int doors){
    this.doors = doors;
  }
  public float getprice(){
    return price;
  }
  public void setprice(float price){
    this.price = price;
  }
  public int getyear(){
    return year;
  }
  public void setyear(int year){
    this.year = year;
  }
  public int getmileage(){
    return mileage;
  }
  public void setmileage(int mileage){
    this.mileage = mileage;
  }

  public boolean isMatch(String VIN, String modelName, String manufacturer){

    return this.VIN.equalsIgnoreCase(VIN) &&
           this.modelName.equalsIgnoreCase(modelName) &&
           this.manufacturer.equalsIgnoreCase(manufacturer);
  }

  public boolean isVINMatch(String VIN){
    return this.VIN.equalsIgnoreCase(VIN);
  }

  public boolean isCarMatch(String modelName, String manufacturer){
    return this.modelName.equalsIgnoreCase(modelName) &&
           this.manufacturer.equalsIgnoreCase(manufacturer);
  }

  public void printCarInfo(){
    System.out.println( "Stock information of the car - \n"+
                        "VIN : " + VIN +"\n"+  
                        "Manufacturer | Model : " + manufacturer + " | " + modelName + "\n"+
                        "Year | Mileage | Price :" + year + " | " + mileage + " | "+ price + "\n" +
                        "Color : exterior, " + exteriorColor + "interior, " + interiorColor + "\n"+
                        "Bodytype | drivetrain | doors : " + bodyType + " | " + drivetrain + " | "+ doors +"\n"+
                        "Fuel Type : " + fuelType );
  }
}

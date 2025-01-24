import model.Stock;
import model.Car;

public class DealershipMain {

    public static void main(String[] args) throws Exception {

        /*Create 15 cars in Car stock*/
        Stock stock = new Stock(2024);

        stock.addNewCar("1J4PP2GK8AW181578","White","Beige",
        "BMW","i3", "Hatchbacks", "Plug-in",
        "Four Wheel Drive","Automatic","Back Bay", 4,
        35000.00f,2023,10000,true,false);

        stock.addNewCar("1HGBH41JXMN109186","Black","Black",
        "Tesla","Model S", "Sedan", "Electric",
        "All Wheel Drive","Automatic","Downtown", 5,
        65000.00f,2022,5000,true,true);

        stock.addNewCar("2T2ZZMCA7KC179678","Silver","Gray",
        "Toyota","RAV4", "SUV", "Hybrid",
        "All Wheel Drive","Automatic","Uptown", 5,
        42000.00f,2021,15000,true,false);

        stock.addNewCar("3VW517AT1FM180385","Blue","Beige",
        "Volkswagen","Golf", "Hatchback", "Gasoline",
        "Front Wheel Drive","Manual","Seaport", 5,
        28000.00f,2020,30000,true,true);

        stock.addNewCar("5GAKVBEDXGJ179298","White","Black",
        "Buick","Enclave", "SUV", "Gasoline",
        "Four Wheel Drive","Automatic","Back Bay", 7,
        50000.00f,2023,12000,true,false);

        stock.addNewCar("1C4PJLDX0JW170940","Red","Black",
        "Jeep","Cherokee", "SUV", "Gasoline",
        "Four Wheel Drive","Automatic","Cambridge", 5,
        37000.00f,2022,8000,false,true);

        stock.addNewCar("JN8AZ2NE5J9157367","Gray","White",
        "Nissan","Murano", "SUV", "Gasoline",
        "All Wheel Drive","Automatic","Downtown", 5,
        33000.00f,2021,25000,false,false);

        stock.addNewCar("4T1BE46KX9U800119","Blue","Gray",
        "Toyota","Camry", "Sedan", "Gasoline",
        "Front Wheel Drive","Automatic","Seaport", 5,
        27000.00f,2020,35000,true,true);

        stock.addNewCar("WA1BNAFY2J2137593","Silver","Black",
        "Audi","Q5", "SUV", "Hybrid",
        "All Wheel Drive","Automatic","Uptown", 5,
        55000.00f,2023,6000,true,true);

        stock.addNewCar("1G1ZG57B694201051","White","Gray",
        "Chevrolet","Malibu", "Sedan", "Gasoline",
        "Front Wheel Drive","Automatic","Cambridge", 5,
        25000.00f,2020,45000,false,false);

        stock.addNewCar("1FAHP3F21CL372192","Red","Beige",
        "Ford","Focus", "Hatchback", "Gasoline",
        "Front Wheel Drive","Manual","Back Bay", 5,
        22000.00f,2021,32000,true,false);

        stock.addNewCar("2C4RC1BG8JR210328","Gray","Black",
        "Chrysler","Pacifica", "Minivan", "Hybrid",
        "Front Wheel Drive","Automatic","Seaport", 7,
        48000.00f,2023,7000,true,true);

        stock.addNewCar("5J6RM4H31FL087582","Black","Gray",
        "Honda","CR-V", "SUV", "Gasoline",
        "All Wheel Drive","Automatic","Uptown", 5,
        36000.00f,2022,11000,true,false);

        stock.addNewCar("YV1CZ852691530758","Silver","Black",
        "Volvo","XC90", "SUV", "Gasoline",
        "All Wheel Drive","Automatic","Downtown", 7,
        62000.00f,2021,14000,false,true);

        stock.addNewCar("WDCGG8JB7BF580307","Blue","Beige",
        "Mercedes-Benz","GLK 350", "SUV", "Gasoline",
        "Four Wheel Drive","Automatic","Cambridge", 5,
        47000.00f,2023,9000,true,true);
    
        /* Printout entire inventory */
        stock.printCarInventory();

        /* Use findInventoryCar to search for a car in reference to VIN, model, or manufacturer */
        
        //VIN
        String VIN_1 = "1HGBH41JXMN109186";
        Car carByVIN = stock.findCarbyVIN(VIN_1);
        if (carByVIN != null) {
            System.out.println("Car found by VIN: " + VIN_1);
            carByVIN.printCarInfo();
            System.out.println("-----------------------------");
        } else {
            System.out.println("No car found with VIN: " + VIN_1);
            System.out.println("-----------------------------");
        }
    
        //Model && Manufacturer
        String Model_1 = "XC90";
        String Make_1 = "Volvo";
        Car carbyModelAndMake = stock.findCarByModelMake(Model_1, Make_1);
        if (carbyModelAndMake != null) {
            System.out.println("Car found by Model and Make : " + Model_1 + " " + Make_1);
            carbyModelAndMake.printCarInfo();
            System.out.println("-----------------------------");
        } else {
            System.out.println("No car found with Model / Make : " + Model_1 + " " + Make_1);
            System.out.println("-----------------------------");
        }
    }
}

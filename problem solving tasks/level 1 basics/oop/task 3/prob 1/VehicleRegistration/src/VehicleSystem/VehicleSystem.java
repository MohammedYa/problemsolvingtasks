
package VehicleSystem;

import Services.VehicleServiceImpl;
import modules.*;

import java.util.List;
import java.util.Scanner;

public class VehicleSystem {

    private final Scanner scanner = new Scanner(System.in);
    VehicleServiceImpl vehicleService= new VehicleServiceImpl();
    private String plateNumber;
    private String ownerName;
    private String vehicleType;
    private int registrationYear;
    private String isActive;
    private int countOfDoor;
    private String typeEnagine;
    private double cargoCapacity;

    public void Start() {
        int chooseNum;
        // Keep displaying the menu until the user chooses Exit.
        int counter=1;
        while (counter<=3){
            System.out.print(
                    """
                                Welcome To Vehicles Showroom\s
                            ========================================
                            1 ----> Register New Vehicle
                            2 ----> Search Vehicle by Plate Number
                            3 ----> Update Owner’s Name
                            4 ----> Delete Vehicle
                            5 ----> List All Vehicles
                            6 ----> Filter by Vehicle Type
                            7 ----> Show Owner History
                            8 ----> Show Expired Registrations
                            9 ----> Statistics Report
                            0 ----> Exit
                            ========================================
                            """
            );
            System.out.print("Enter your number: ");


            try {
                chooseNum = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character.

                switch (chooseNum) {
                    case 1:
                        registerNewVehicle();
                        break;
                    case 2:
                        searchVehiclePlate();
                        break;
                    case 3:
                        updateOwnerName();
                        break;
                    case 4:
                        deleteVehicle();
                        break;
                    case 5:
                        listAllVehicles();
                        break;
                    case 6:
                        filterVehicleType();
                        break;
                    case 7:
                        showOwnerHistory();
                        break;
                    case 8:
                        showExpiredRegistrations();
                        break;
                    case 9:
                        statisticsReport();
                        break;
                    case 0:
                        System.out.print("Goodbye!");
                        break;
                    default:
                        if(counter<3) {System.out.println("Remaining attempts: " + (3 - counter)+"\n");}
                        else{ System.out.print( "Your choose is not Exist Try Again Later :( \n");}
                        counter++;
                        break;
                }

            }
            catch (java.util.InputMismatchException ex) {
                // Remove the invalid input, such as letters, from the scanner.
                scanner.nextLine();
                System.out.print(" You Should Enter the Invalid Number  from 1 to 3 \n");
                counter++;

                if (counter < 3) {
                    System.out.println(
                            "Invalid input. Remaining attempts: "
                                    + (3 - counter));
                } else {
                    System.out.println(
                            "Too many invalid attempts. Try again later.");
                }
            }
        }

    }




    // Registers a new vehicle.
    private void registerNewVehicle() {
        System.out.print("Register New Vehicle Page .\n");

        // Receive the vehicle plate number.
        System.out.print("Enter plate number: \n");
         plateNumber = scanner.nextLine();

        // Receive the owner's name.
        System.out.print("Enter owner name: \n");
         ownerName = scanner.nextLine();

        // Receive the vehicle type.
        System.out.print("Enter vehicle type:     1 ----> Car  |   2 ----> Truck   |   3 ----> Motorcycle \n");
          int type = scanner.nextInt();
        switch (type){
            case 1:
                vehicleType="Car";
                System.out.print("Enter count of car’s door : \n");
                countOfDoor = scanner.nextInt();
                break;
            case 2:
                vehicleType="Truck";
                System.out.print("Enter Cargo Capacity: \n");
                cargoCapacity = scanner.nextDouble();
                break;
            case 3:
                vehicleType="Motorcycle";
                System.out.print("Enter Type Of Engine : \n");
                typeEnagine = scanner.nextLine();
                break;
            default:
                vehicleType="Car";
                countOfDoor = 4;
                break;

        }

        // Receive the registration year.
        System.out.print("Enter registration year: \n");
         registrationYear = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character.

        // Receive the active status.
        System.out.print("Is the vehicle active? insert   1 ------> ACTIVE   insert 2  ------> EXPIRED :\n ");
        int status=scanner.nextInt();
        if(status==1){isActive="ACTIVE";}
        else {isActive="EXPIRED";}

        scanner.nextLine(); // Consume the newline character.

        Vehicle vehicle;

        // Create the appropriate child object.
        switch (vehicleType) {
            case "Car":
                vehicle = new car(
                        plateNumber, ownerName, vehicleType,
                        registrationYear, isActive, countOfDoor
                );
                break;

            case "Truck":
                vehicle = new truck(
                        plateNumber, ownerName, vehicleType,
                        registrationYear, isActive, cargoCapacity
                );
                break;

            case "Motorcycle":
                vehicle = new Motorcycle(
                        plateNumber, ownerName, vehicleType,
                        registrationYear, isActive, typeEnagine
                );
                break;

            default:
                return;
        }

        // Send the object to the service for registration.
         Vehicle vehicleCreated= vehicleService.createVehicle(vehicle);
        if(vehicleCreated==null){
            System.out.print("Account is Already Exist ..............\n");
        }
        else{
            System.out.print("Vehicle  Inserted Successfully..............\n");


        }

    }

    // Searches for a vehicle using its plate number.
    private void searchVehiclePlate() {
        System.out.print("Search Vehicle by Plate .\n");
        System.out.print("Enter plate number: \n");
        plateNumber = scanner.nextLine();
        Vehicle vehicle=  vehicleService.getVehicleByPlateNumber(plateNumber);
        System.out.print(vehicle);
//        if (vehicle != null) {vehicle.toString();}else {System.out.println("Vehicle Is Not Exist");}

    }

    // Updates the owner's name.
    private void updateOwnerName() {
        System.out.print("Update Owner Name .");
        System.out.print("Enter plate number: \n");
        plateNumber = scanner.nextLine();
        Vehicle vehicle=  vehicleService.getVehicleByPlateNumber(plateNumber);
        if (vehicle != null)
        {
            System.out.print("Insert  New  Owner’s name .");
            ownerName = scanner.nextLine();
            vehicleService.updateOwnerNameVehicle(plateNumber,ownerName);
            System.out.println(vehicleService.updateOwnerNameVehicle(plateNumber,ownerName));

        }
        else {System.out.println("Vehicle Is Not Exist");}

    }

    // Deletes a registered vehicle.
    private void deleteVehicle() {
        System.out.print("Delete Vehicle Page .\n");
        System.out.print("Enter plate number: \n");
        plateNumber = scanner.nextLine();
        vehicleService.deleteVehicle(plateNumber);

    }

    // Displays all registered vehicles.
    private void listAllVehicles() {
        System.out.print("List All Vehicles .");
        List<Vehicle>vehicles=vehicleService.getVehicle();
        vehicles.forEach(vehicle -> System.out.print(vehicle.toString()+"\n"));
    }

    // Filters vehicles by their type.
    private void filterVehicleType() {

        boolean status=true;
        int counter=1;
        while(status&&counter<=3){
        System.out.println("Filter by Vehicle Type selected. \n  1 ----> Car     2 ----> Truck     3 ----> Motorcycle \n");
        int typeNum= scanner.nextInt();

            switch (typeNum) {
                case 1:
                     List<Vehicle>carVehicle=  vehicleService.filterVehicleType("Car");
                    carVehicle.stream().forEach(System.out::println);
                    status=false;
                    break;
                case 2:
                    List<Vehicle>truckVehicle=  vehicleService.filterVehicleType("Truck");
                    truckVehicle.stream().forEach(System.out::println);

                    status=false;
                    break;
                case 3:
                    List<Vehicle>motorcycleVehicle=  vehicleService.filterVehicleType("Motorcycle");
                    motorcycleVehicle.stream().forEach(System.out::println);

                    status=false;
                    break;
                default:
                    if(counter<3) {System.out.println("Remaining attempts: " + (3 - counter)+"\n");}
                    else{ System.out.print( "Your choose is not Exist Try Again Later :( \n");Start();}
                    counter++;
                    break;


            }
        }
    }

    // Displays the ownership history.
    private void showOwnerHistory() {
        System.out.println("Show Owner History selected.");
    }

    // Displays vehicles with expired registrations.
    private void showExpiredRegistrations() {
        System.out.println("Show Expired Registrations selected.");
        boolean status=true;
        int counter=1;
        while(status&&counter<=3){
            System.out.println("Filter by ( STATUS ) OF Vehicle  selected. \n  1 ----> ACTIVE     2 ----> EXPIRED     \n");
            int typeNum= scanner.nextInt();
            List<Vehicle>Vehicle;
            switch (typeNum) {
                case 1:
                    Vehicle=  vehicleService.filterVehicleStatus("ACTIVE");
                    Vehicle.stream().forEach(System.out::println);
                    status=false;
                    break;
                case 2:
                    Vehicle=  vehicleService.filterVehicleStatus("EXPIRED");
                    Vehicle.stream().forEach(System.out::println);

                    status=false;
                    break;

                default:
                    if(counter<3) {System.out.println("Remaining attempts: " + (3 - counter)+"\n");}
                    else{ System.out.print( "Your choose is not Exist Try Again Later :( \n");Start();}
                    counter++;
                    break;


            }
        }
    }

    // Displays vehicle registration statistics.
    private void statisticsReport() {
        System.out.println("Statistics Report selected.");
    }



}


package VehicleSystem;

import Services.VehicleService;
import Services.VehicleServiceImpl;
import ValidatorAndExeption.ValidationUtils;
import modules.*;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

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
                            \n    Welcome To Vehicles Showroom\s
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
                System.out.print(" You Should Enter the Invalid Number  from 0 to 9 \n");
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

        // Read values again until they pass the corresponding validators.
        plateNumber = readValidatedInput(
                "Enter plate number: ", ValidationUtils::isPlateNumberValid,
                "Invalid plate number. Use 3 to 10 letters, digits, or hyphens.");
        ownerName = readValidatedInput(
                "Enter owner name: ", ValidationUtils::isOwnerNameValid,
                "Invalid owner name. Use name parts of 3 to 10 letters.");

        // Receive the vehicle type.
        System.out.print("Enter vehicle type:     1 ----> Car  |   2 ----> Truck   |   3 ----> Motorcycle \n");
        int type = scanner.nextInt();
        scanner.nextLine();
        while (type < 1 || type > 3) {
            System.out.print("Invalid choice. Enter 1 for Car, 2 for Truck, or 3 for Motorcycle: ");
            type = scanner.nextInt();
            scanner.nextLine();
        }
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
                typeEnagine = scanner.next();
                scanner.nextLine();
                break;
            default:
                return;

        }
        if (!ValidationUtils.isVehicleTypeValid(vehicleType)) {
            System.out.println("Invalid vehicle type.");
            return;
        }

        // Receive the registration year.
        System.out.print("Enter registration year: \n");
         registrationYear = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character.
        while (!ValidationUtils.isRegistrationYearValid(registrationYear)) {
            System.out.println("Invalid year. Enter a year from 1990 through "
                    + java.time.Year.now().getValue() + ".");
            System.out.print("Enter registration year: ");
            registrationYear = scanner.nextInt();
            scanner.nextLine();
        }

        // Receive the active status.
        System.out.print("Is the vehicle active? insert   1 ------> ACTIVE   insert 2  ------> EXPIRED :\n ");
        int status=scanner.nextInt();
        while (status != 1 && status != 2) {
            System.out.print("Invalid choice. Enter 1 for ACTIVE or 2 for EXPIRED: ");
            status = scanner.nextInt();
        }
        if(status==1){isActive="ACTIVE";}
        else if (status==2) {isActive="EXPIRED";}
        if (!ValidationUtils.isActiveValid(isActive)) {
            System.out.println("Invalid registration status.");
            return;
        }

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
        System.out.print(vehicle +"\n");

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
            ownerName = readValidatedInput(
                    "Insert new owner's name: ", ValidationUtils::isOwnerNameValid,
                    "Invalid owner name. Use name parts of 3 to 10 letters.");
            vehicleService.updateOwnerNameVehicle(plateNumber,ownerName);
            System.out.println(vehicleService.updateOwnerNameVehicle(plateNumber,ownerName));

        }
        else {System.out.println("Vehicle Is Not Exist");}

    }

    /** Reads text from the console until the supplied validation rule accepts it. */
    private String readValidatedInput(String prompt, Predicate<String> validator,
                                      String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (validator.test(input)) {
                return input;
            }
            System.out.println(errorMessage);
        }
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
        System.out.print("Show Owner History selected.");
        System.out.print("Enter Owner Name :");
        String ownerName=scanner.next();
        List<Vehicle>ownerVehicle=  vehicleService.filterVehicleOwner(ownerName);

        if (ownerName.isEmpty())
        {
            System.out.print("Owner name is not Found  :");

        }
        else
        {
            ownerVehicle.stream().forEach(System.out::println);
        }
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
        System.out.print(vehicleService.getStatisticsVehicle());
        vehicleService.getStatisticsVehicle();
    }



}

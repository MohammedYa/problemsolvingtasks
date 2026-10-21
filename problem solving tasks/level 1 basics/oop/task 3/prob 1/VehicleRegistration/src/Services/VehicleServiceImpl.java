package Services;

import modules.RegistrationSystem;
import modules.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VehicleServiceImpl implements VehicleService {
    RegistrationSystem registrationSystem = new RegistrationSystem();


    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        // Check whether the plate number already exists.
        boolean isVehicleExist = registrationSystem.getVehicleList()
                .stream()
                .anyMatch(existingVehicle ->
                        existingVehicle.getPlateNumber()
                                .equalsIgnoreCase(vehicle.getPlateNumber()));

        // Prevent duplicate registration.
        if (isVehicleExist) {
            System.out.print("This plate number already exists!");
            return null;
        }

        // Add the vehicle to the List.
        registrationSystem.getVehicleList().add(vehicle);

        // Return the created vehicle.
        return vehicle;
    }
    @Override
    public Vehicle getVehicleByPlateNumber(String plateNumber) {
        Optional<Vehicle>currentVehicle=registrationSystem.getVehicleList().stream()
                                 .filter(vehicle->vehicle.getPlateNumber().equals(plateNumber)).findFirst();
        return currentVehicle.orElse(null);
    }
    @Override
    public String updateOwnerNameVehicle(String plateNumber,String ownerName) {
       Optional<Vehicle>existVehicle=registrationSystem.getVehicleList().stream()
                                     .filter(vehicle->vehicle.getPlateNumber().equals(plateNumber)).findFirst();
        if(existVehicle.isPresent()){
            existVehicle.get().setOwnerName(ownerName);
            return "Owner Name Changed Successfully";
        }
        else{
           return "Vehicle is not Exist .....";
        }
    }
    @Override
    public String deleteVehicle(String plateNumber) {
        Optional<Vehicle>existVehicle=registrationSystem.getVehicleList().stream()
                .filter(vehicle->vehicle.getPlateNumber().equals(plateNumber)).findFirst();
        if(existVehicle.isPresent()){
            registrationSystem.getVehicleList().remove(existVehicle.get());
            System.out.print("Vehicle Deleted  Successfully");
            return "Vehicle Deleted  Successfully";
        }
        else{
            return "Vehicle is not Exist .....";
        }
    }
    @Override
    public List<Vehicle> getVehicle(){
        List<Vehicle>vehicles =registrationSystem.getVehicleList();
        if(vehicles.isEmpty()){
            System.out.print("Vehicle is Not Registed Yet");
            return vehicles;
        }
        else return vehicles;
    }
    @Override
    public List<Vehicle> filterVehicleType(String type) {

        return registrationSystem.getVehicleList().stream()
                .filter(vehicles->vehicles.getVehicleType().equalsIgnoreCase(type)).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> filterVehicleStatus(String status) {
        return registrationSystem.getVehicleList().stream()
                .filter(vehicles->vehicles.getIsActive().equalsIgnoreCase(status)).collect(Collectors.toList());
    }

}
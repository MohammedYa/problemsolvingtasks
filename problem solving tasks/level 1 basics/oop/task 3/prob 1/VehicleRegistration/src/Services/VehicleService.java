package Services;

import modules.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle getVehicleByPlateNumber(String plateNumber);
    String updateOwnerNameVehicle(String plateNumber,String ownername);
    String deleteVehicle(String plateNumber);
    List<Vehicle> getVehicle();
    List<Vehicle>filterVehicleType(String type);
    List<Vehicle>filterVehicleStatus(String status);
}

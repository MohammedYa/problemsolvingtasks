
package Services;

import modules.Vehicle;
import java.util.List;

/**
 * Defines the operations available for managing vehicle registrations.
 * Includes creating, retrieving, updating, deleting, filtering,
 * and generating statistics for vehicles.
 */
public interface VehicleService {

    /**
     * Registers a new vehicle in the system.
     *
     * @param vehicle the vehicle to be registered
     * @return the created vehicle
     */
    Vehicle createVehicle(Vehicle vehicle);

    /**
     * Retrieves a vehicle using its plate number.
     *
     * @param plateNumber the plate number of the vehicle
     * @return the vehicle matching the given plate number
     */
    Vehicle getVehicleByPlateNumber(String plateNumber);

    /**
     * Updates the owner's name for a specific vehicle.
     *
     * @param plateNumber the plate number of the vehicle
     * @param ownername the new owner's name
     * @return a message describing the update result
     */
    String updateOwnerNameVehicle(String plateNumber, String ownername);

    /**
     * Deletes a vehicle from the registration system.
     *
     * @param plateNumber the plate number of the vehicle to delete
     * @return a message describing the deletion result
     */
    String deleteVehicle(String plateNumber);

    /**
     * Retrieves all registered vehicles.
     *
     * @return a list containing all registered vehicles
     */
    List<Vehicle> getVehicle();

    /**
     * Filters vehicles by their type.
     *
     * @param type the vehicle type, such as Car, Truck, or Motorcycle
     * @return a list of vehicles matching the specified type
     */
    List<Vehicle> filterVehicleType(String type);

    /**
     * Filters vehicles by their registration status.
     *
     * @param status the status used for filtering, such as ACTIVE or EXPIRED
     * @return a list of vehicles matching the specified status
     */
    List<Vehicle> filterVehicleStatus(String status);

    /**
     * Generates a statistical report about registered vehicles.
     *
     * @return a formatted string containing vehicle registration statistics
     */
    String getStatisticsVehicle();

    /**
     * Searches for vehicles using the owner's name.
     *
     * @param ownerName the owner's name or a part of the name
     * @return a list of vehicles associated with the specified owner name
     */
    List<Vehicle> filterVehicleOwner(String ownerName);
}

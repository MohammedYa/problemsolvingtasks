
package Services;

import modules.RegistrationSystem;
import modules.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implements the VehicleService interface.
 * Provides operations for registering, retrieving, updating,
 * deleting, filtering, and analyzing registered vehicles.
 */
public class VehicleServiceImpl implements VehicleService {

    // Creates a registration system that stores the vehicle list.
    RegistrationSystem registrationSystem = new RegistrationSystem();

    /**
     * Registers a new vehicle if its plate number does not already exist.
     *
     * @param vehicle the vehicle to be registered
     * @return the created vehicle, or null if the plate number already exists
     */
    @Override
    public Vehicle createVehicle(Vehicle vehicle) {

        // Check whether another vehicle has the same plate number.
        boolean isVehicleExist = registrationSystem.getVehicleList()
                .stream()
                .anyMatch(existingVehicle ->
                        existingVehicle.getPlateNumber()
                                .equalsIgnoreCase(vehicle.getPlateNumber()));

        // Stop registration if the plate number is already used.
        if (isVehicleExist) {
            System.out.print("This plate number already exists!");
            return null;
        }

        // Add the new vehicle to the registration list.
        registrationSystem.getVehicleList().add(vehicle);

        // Return the successfully registered vehicle.
        return vehicle;
    }

    /**
     * Searches for a vehicle using its plate number.
     *
     * @param plateNumber the plate number to search for
     * @return the matching vehicle, or null if no match is found
     */
    @Override
    public Vehicle getVehicleByPlateNumber(String plateNumber) {

        // Filter the list and retrieve the first matching vehicle.
        Optional<Vehicle> currentVehicle = registrationSystem.getVehicleList()
                .stream()
                .filter(vehicle ->
                        vehicle.getPlateNumber().equals(plateNumber))
                .findFirst();

        // Return the vehicle if found; otherwise, return null.
        return currentVehicle.orElse(null);
    }

    /**
     * Updates the owner name of an existing vehicle.
     *
     * @param plateNumber the plate number of the vehicle
     * @param ownerName the new owner's name
     * @return a message describing the update result
     */
    @Override
    public String updateOwnerNameVehicle(String plateNumber, String ownerName) {

        // Find the vehicle that matches the given plate number.
        Optional<Vehicle> existVehicle = registrationSystem.getVehicleList()
                .stream()
                .filter(vehicle ->
                        vehicle.getPlateNumber().equals(plateNumber))
                .findFirst();

        // Update the owner name if the vehicle exists.
        if (existVehicle.isPresent()) {
            existVehicle.get().setOwnerName(ownerName);
            return "Owner Name Changed Successfully";
        } else {
            // Return an error message if no matching vehicle exists.
            return "Vehicle is not Exist .....";
        }
    }

    /**
     * Removes a vehicle from the registration list.
     *
     * @param plateNumber the plate number of the vehicle to delete
     * @return a message describing the deletion result
     */
    @Override
    public String deleteVehicle(String plateNumber) {

        // Search for the vehicle before attempting deletion.
        Optional<Vehicle> existVehicle = registrationSystem.getVehicleList()
                .stream()
                .filter(vehicle ->
                        vehicle.getPlateNumber().equals(plateNumber))
                .findFirst();

        // Remove the vehicle if it was found.
        if (existVehicle.isPresent()) {
            registrationSystem.getVehicleList().remove(existVehicle.get());
            System.out.print("Vehicle Deleted Successfully");
            return "Vehicle Deleted Successfully";
        } else {
            // Report that the vehicle could not be found.
            return "Vehicle is not Exist .....";
        }
    }

    /**
     * Retrieves all registered vehicles.
     *
     * @return the list containing the registered vehicles
     */
    @Override
    public List<Vehicle> getVehicle() {

        // Get the current list of registered vehicles.
        List<Vehicle> vehicles = registrationSystem.getVehicleList();

        // Notify the user if the list is empty.
        if (vehicles.isEmpty()) {
            System.out.print("Vehicle is Not Registered Yet");
        }

        // Return the list whether it is empty or populated.
        return vehicles;
    }

    /**
     * Filters vehicles according to their type.
     *
     * @param type the requested type, such as Car, Truck, or Motorcycle
     * @return a list containing vehicles of the specified type
     */
    @Override
    public List<Vehicle> filterVehicleType(String type) {

        // Keep only vehicles whose type matches the requested type.
        return registrationSystem.getVehicleList()
                .stream()
                .filter(vehicle ->
                        vehicle.getVehicleType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    /**
     * Filters vehicles according to their registration status.
     *
     * @param status the requested status, such as ACTIVE or EXPIRED
     * @return a list containing vehicles with the specified status
     */
    @Override
    public List<Vehicle> filterVehicleStatus(String status) {

        // Keep only vehicles whose status matches the requested status.
        return registrationSystem.getVehicleList()
                .stream()
                .filter(vehicle ->
                        vehicle.getIsActive().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    /**
     * Generates a formatted report containing vehicle statistics.
     *
     * Calculates the total number of vehicles, average registration year,
     * newest and oldest registration years, counts by vehicle type,
     * and counts of active and expired vehicles.
     *
     * @return a formatted string containing the statistics report
     */
    @Override
    public String getStatisticsVehicle() {

        // Count all registered vehicles.
        int countVehicles = getVehicle().size();

        // Calculate the average registration year and round to the nearest integer.
        int averageYear = (int) Math.round(
                getVehicle().stream()
                        .mapToInt(Vehicle::getRegistrationYear)
                        .average()
                        .orElse(0)
        );

        // Find the maximum registration year.
        int newestVehicle = getVehicle().stream()
                .mapToInt(Vehicle::getRegistrationYear)
                .max()
                .orElse(0);

        // Find the minimum registration year.
        int oldestVehicle = getVehicle().stream()
                .mapToInt(Vehicle::getRegistrationYear)
                .min()
                .orElse(0);

        // Count vehicles by type.
        int counterCarVehicles = filterVehicleType("Car").size();
        int counterTruckVehicles = filterVehicleType("Truck").size();
        int counterMotorcycleVehicles = filterVehicleType("Motorcycle").size();

        // Count vehicles by registration status.
        int counterActiveVehicles = filterVehicleStatus("ACTIVE").size();
        int counterExpireVehicles = filterVehicleStatus("EXPIRED").size();

        // Build the report by inserting the calculated values into the text.
        String statistics = String.format("""
                ========== REGISTRATION STATISTICS ==========
                Total Vehicles : %d
                Average Year : %d
                Newest Vehicle : %d
                Oldest Vehicle : %d
                ----------------------------------------------
                Vehicles by Type:
                 Car : %d
                 Truck : %d
                 Motorcycle : %d
                ----------------------------------------------
                ACTIVE vehicles : %d
                EXPIRED vehicles: %d
                ==============================================
                """,
                countVehicles,
                averageYear,
                newestVehicle,
                oldestVehicle,
                counterCarVehicles,
                counterTruckVehicles,
                counterMotorcycleVehicles,
                counterActiveVehicles,
                counterExpireVehicles
        );

        // Return the completed report to the caller.
        return statistics;
    }

    /**
     * Searches for vehicles using the full or partial owner name.
     *
     * The search ignores letter case and excludes vehicles with null owner names.
     *
     * @param ownerName the owner's name or part of the name
     * @return a list of matching vehicles, or an empty list for blank input
     */
    @Override
    public List<Vehicle> filterVehicleOwner(String ownerName) {

        // Reject null or blank search input.
        if (ownerName == null || ownerName.isBlank()) {
            return new ArrayList<>();
        }

        // Find vehicles whose owner names contain the search text.
        // Convert both strings to lowercase to ignore letter case.
        return registrationSystem.getVehicleList()
                .stream()
                .filter(vehicle ->
                        vehicle.getOwnerName() != null
                                && vehicle.getOwnerName().toLowerCase()
                                .contains(ownerName.trim().toLowerCase()))
                .collect(Collectors.toList());
    }
}

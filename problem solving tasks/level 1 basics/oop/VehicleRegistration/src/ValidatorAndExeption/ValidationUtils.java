
package ValidatorAndExeption;

import java.time.Year;

/**
 * Provides validation methods for vehicle registration data.
 */
public class ValidationUtils {

    /**
     * Checks that a plate number contains 3 to 10 letters, digits, or hyphens.
     *
     * @param plateNumber the plate number to validate
     * @return {@code true} if the plate number meets the format requirements
     */
    public static boolean isPlateNumberValid(String plateNumber) {
        if (plateNumber == null || plateNumber.isBlank()) {
            return false;
        }
        return plateNumber.matches("[A-Za-z0-9-]{3,10}");
    }

    /**
     * Checks that an owner's name consists of one or more 3-to-10-letter parts
     * separated by whitespace.
     *
     * @param ownerName the owner's name to validate
     * @return {@code true} if the name meets the format requirements
     */
    public static boolean isOwnerNameValid(String ownerName) {
        if (ownerName == null || ownerName.isBlank()) {
            return false;
        }
        return ownerName.matches("[A-Za-z]{3,10}(?:\\s+[A-Za-z]{3,10})*");
    }

    /**
     * Checks whether the vehicle type is Car, Truck, or Motorcycle,
     * ignoring letter case.
     *
     * @param vehicleType the vehicle type to validate
     * @return {@code true} if the type is supported
     */
    public static boolean isVehicleTypeValid(String vehicleType) {
        return vehicleType != null
                && (vehicleType.equalsIgnoreCase("Car")
                || vehicleType.equalsIgnoreCase("Truck")
                || vehicleType.equalsIgnoreCase("Motorcycle"));
    }

    /**
     * Checks whether the registration year is between 1990 and the current year,
     * inclusive.
     *
     * @param registrationYear the registration year to validate
     * @return {@code true} if the year is within the allowed range
     */
    public static boolean isRegistrationYearValid(int registrationYear) {
        return registrationYear >= 1990 && registrationYear <= Year.now().getValue();
    }

    /**
     * Checks whether the status is ACTIVE or EXPIRED, ignoring letter case.
     *
     * @param status the registration status to validate
     * @return {@code true} if the status is supported
     */
    public static boolean isActiveValid(String status) {
        return status != null
                && (status.equalsIgnoreCase("ACTIVE")
                || status.equalsIgnoreCase("EXPIRED"));
    }
}

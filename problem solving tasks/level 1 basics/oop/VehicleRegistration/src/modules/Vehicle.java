
package modules;

public abstract class Vehicle {

    // Constructor: initializes the vehicle's properties.
    public Vehicle(String plateNumber, String ownerName,
                   String vehicleType, int registrationYear,
                   String isActive) {

        setPlateNumber(plateNumber);
        setOwnerName(ownerName);
        setVehicleType(vehicleType);
        setRegistrationYear(registrationYear);
        setActive(isActive);
    }

    // Private fields to store the vehicle's information.
    private String plateNumber;
    private String ownerName;
    private String vehicleType;
    private int registrationYear;
    private String isActive;

    // Sets the vehicle's plate number.
    private void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    // Updates the vehicle owner's name.
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    // Sets the vehicle type.
    private void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    // Sets the vehicle's registration year.
    private void setRegistrationYear(int registrationYear) {
        this.registrationYear = registrationYear;
    }

    // Updates whether the vehicle is active.
    public void setActive(String active) {
        this.isActive = active;
    }

    // Returns the vehicle's plate number.
    public String getPlateNumber() {
        return plateNumber;
    }

    // Returns the owner's name.
    public String getOwnerName() {
        return ownerName;
    }

    // Returns the registration year.
    public int getRegistrationYear() {
        return registrationYear;
    }

    // Returns the vehicle type.
    public String getVehicleType() {
        return vehicleType;
    }

    // Returns whether the vehicle is active.
    public String getIsActive() {
        return isActive;
    }

    // Abstract method: subclasses must provide their own registration label.
    abstract String getRegistrationLabel();

    // Returns a readable string containing the vehicle's information.
    @Override
    public String toString() {
        return "[" + this.getPlateNumber() + "]" +
                "  ###  " + this.getVehicleType() +
                "  ###   Owner’s name     " + this.getOwnerName() +
                "  ###  " + this.getRegistrationYear() +
                "  ###  " + this.getIsActive()+"  ###  " ;
    }

    // Compares two vehicles based on their plate numbers.
    // Vehicles with the same plate number are equal, ignoring letter case.
    @Override
    public boolean equals(Object o) {

        // The same object reference is always equal to itself.
        if (o == this)
            return true;

        // An object cannot be equal to null or an object of a different class.
        if (o == null || getClass() != o.getClass())
            return false;

        // Cast the object to Vehicle to access its plate number.
        Vehicle vehicle = (Vehicle) o;

        // Compare plate numbers without considering uppercase or lowercase letters.
        return this.plateNumber.equalsIgnoreCase(vehicle.plateNumber);
    }

    // Generates a hash code based on the plate number.
    // Converting to lowercase ensures equal plate numbers produce the same hash code.
    @Override
    public int hashCode() {
        return plateNumber.toLowerCase(java.util.Locale.ROOT).hashCode();
    }
}

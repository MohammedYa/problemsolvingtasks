
package modules;

// Truck inherits the common properties and methods from Vehicle.
public class truck extends Vehicle {

    // Stores the maximum cargo capacity of the truck in tons.
    private double cargoCapacity;

    // Constructor: initializes the inherited properties and truck-specific data.
    public truck(String plateNumber, String ownerName,
                 String vehicleType, int registrationYear,
                 String isActive, double cargoCapacity) {

        // Calls the parent constructor to initialize the common vehicle properties.
        super(plateNumber, ownerName, vehicleType,
                registrationYear, isActive);

        // Sets the truck's cargo capacity using the setter method.
        setCargoCapacity(cargoCapacity);
    }

    // Updates the truck's cargo capacity.
    public void setCargoCapacity(double cargoCapacity) {
        // Assigns the provided value to the object's cargoCapacity field.
        this.cargoCapacity = cargoCapacity;
    }

    // Returns the truck's cargo capacity.
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    // Overrides the abstract method from Vehicle to provide a truck-specific label.
    @Override
    String getRegistrationLabel() {
        // Returns a label containing the vehicle type and cargo capacity.
        return "Commercial Truck — Cargo: "
                + this.getCargoCapacity() + " tons";
    }

    // Overrides the parent toString() to include the truck's additional information.
    @Override
    public String toString() {
        // Reuses the common vehicle information and appends the cargo capacity.
        return super.toString()
                + " Cargo Capacity Is: ("
                + this.getCargoCapacity() + ") tons "+"  ###  " ;
    }
}

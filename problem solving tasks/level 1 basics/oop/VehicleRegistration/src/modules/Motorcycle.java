
package modules;

// Motorcycle inherits the common properties and methods from Vehicle.
public class Motorcycle extends Vehicle {

    // Stores the motorcycle's engine type.
    private String engineType;

    // Initializes the inherited vehicle properties and the engine type.
    public Motorcycle(String plateNumber, String ownerName,
                      String vehicleType, int registrationYear,
                      String isActive, String engineType) {

        // Calls the parent constructor to initialize common vehicle properties.
        super(plateNumber, ownerName, vehicleType,
                registrationYear, isActive);

        // Sets the engine type using the setter method.
        setEngineType(engineType);
    }

    // Updates the motorcycle's engine type.
    public void setEngineType(String engineType) {
        // Assigns the provided value to the object's engineType field.
        this.engineType = engineType;
    }

    // Returns the motorcycle's engine type.
    public String getEngineType() {
        return engineType;
    }

    // Includes the inherited vehicle information and the engine type.
    @Override
    public String toString() {
        return super.toString()
                + " Motorcycle —  Engine: "
                + this.getEngineType()+"  ###  \n" ;
    }

    // Implements the abstract method defined in Vehicle.
    @Override
    String getRegistrationLabel() {
        // Returns a registration label specific to motorcycles.
        return "Motorcycle — Engine: "
                + this.getEngineType();
    }
}

package modules;

// Car inherits the common properties and methods from Vehicle.
public class car extends Vehicle {

    // Stores the number of doors in the car.
    // The default value is 4.
    private int numOfDoor = 4;

    // Constructor: initializes the inherited vehicle properties and the number of doors.
    public car(String plateNumber, String ownerName,
               String vehicleType, int registrationYear,
               String isActive, int numOfDoor) {

        // Calls the parent constructor to initialize the common vehicle properties.
        super(plateNumber, ownerName, vehicleType,
                registrationYear, isActive);

        // Sets the number of doors using the setter method.
        setNumOfDoor(numOfDoor);
    }

    // Updates the number of doors in the car.
    public void setNumOfDoor(int numOfDoor) {
        // Assigns the provided value to the object's numOfDoor field.
        this.numOfDoor = numOfDoor;
    }

    // Returns the number of doors in the car.
    public int getNumOfDoor() {
        return numOfDoor;
    }

    // Overrides the parent toString() to include car-specific information.
    @Override
    public String toString() {
        // Reuses the common vehicle information and appends the number of doors.
        return super.toString()
                + " Passenger Car —  Doors:  ("
                + this.getNumOfDoor()+" ) ###  \n" ;
    }

    // Implements the abstract method defined in Vehicle.
    @Override
    String getRegistrationLabel() {
        // Returns a registration label containing the car type and number of doors.
        return "Passenger Car — Doors: "
                + this.getNumOfDoor();
    }
}
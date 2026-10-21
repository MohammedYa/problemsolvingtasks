
package modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RegistrationSystem {

    // Stores all registered vehicles in insertion order.
    private List<Vehicle> vehicleList = new ArrayList<>();

    // Maps each plate number to its vehicle for fast lookup.
    private Map<String, Vehicle> plateIndex = new HashMap<>();

    // Stores registered plate numbers to check for duplicates efficiently.
    private Set<String> registeredPlates = new HashSet<>();



    public void setRegisteredPlates(Set<String> registeredPlates) {
        this.registeredPlates = registeredPlates;
    }

    public void setPlateIndex(Map<String, Vehicle> plateIndex) {
        this.plateIndex = plateIndex;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }



    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public Map<String, Vehicle> getPlateIndex() {
        return plateIndex;
    }

    public Set<String> getRegisteredPlates() {
        return registeredPlates;
    }
}

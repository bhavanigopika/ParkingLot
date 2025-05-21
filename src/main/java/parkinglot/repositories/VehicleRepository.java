package parkinglot.repositories;

import parkinglot.models.Vehicle;

import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    //map vehicle id to vehicle so, Long, Vehicle
    private Map<Long, Vehicle> vehicleMap;
    //findById is fast query because id will be primary index

    //Let's get vehicle information by vehicle number in database -> we go for *index on number*
    //id, number -> index on number
    //Let's create a map of vehicle number to the vehicle -> If not create a map for vehicle number then I iterate
    //all the vehicles from the map and find the particular vehicle

    //map vehicle number to vehicle so, String, Vehicle
    private Map<String, Vehicle> vehicleNumbeVehiclerMap;

    public Optional<Vehicle> findByVehicleNumber(String VehicleNumber){
       return Optional.ofNullable(vehicleMap.get(VehicleNumber));
    }

    public Optional<Vehicle> findById(Long vehicleId) {
        return Optional.ofNullable(vehicleMap.get(vehicleId));
    }

    public Vehicle save(Vehicle vehicle) {
        vehicleMap.put(vehicle.getId(), vehicle);
        return vehicle;
    }
}

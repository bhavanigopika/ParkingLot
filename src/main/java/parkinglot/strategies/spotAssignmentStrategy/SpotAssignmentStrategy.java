package parkinglot.strategies.spotAssignmentStrategy;

import parkinglot.models.Gate;
import parkinglot.models.ParkingSpot;
import parkinglot.models.enums.VehicleType;

public interface SpotAssignmentStrategy {
    //to assign a spot, we need which vehicle? So, I need vehicle type and which gate to park the vehicle?
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate);
}

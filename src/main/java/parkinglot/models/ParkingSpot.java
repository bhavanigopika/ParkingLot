package parkinglot.models;

import parkinglot.models.enums.ParkingSpotStatus;
import parkinglot.models.enums.VehicleType;

import java.util.List;

public class ParkingSpot extends BaseModel{
    private int parkingSpotNumber;
    private ParkingSpotStatus parkingSpotStatus;
    private List<VehicleType> vehicleTypeList;

    public int getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(int parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public List<VehicleType> getVehicleTypeList() {
        return vehicleTypeList;
    }

    public void setVehicleTypeList(List<VehicleType> vehicleTypeList) {
        this.vehicleTypeList = vehicleTypeList;
    }
}

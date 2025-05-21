package parkinglot.models;

import parkinglot.models.enums.FeeCalculationStrategyType;
import parkinglot.models.enums.SpotAssignmentStrategyType;
import parkinglot.models.enums.VehicleType;

import java.util.List;

public class ParkingLot extends BaseModel {
    private ParkingFloor parkingFloor;
    private String address;
    private List<Gate> gateList;
    private List<VehicleType> vehicleTypeList;
    //based on fees, you assigned your vehicle in parking lot
    private FeeCalculationStrategyType feeCalculationStrategyType;
    //Use different spot to assign your vehicle
    private SpotAssignmentStrategyType spotAssignmentStrategyType;

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Gate> getGateList() {
        return gateList;
    }

    public void setGateList(List<Gate> gateList) {
        this.gateList = gateList;
    }

    public List<VehicleType> getVehicleTypeList() {
        return vehicleTypeList;
    }

    public void setVehicleTypeList(List<VehicleType> vehicleTypeList) {
        this.vehicleTypeList = vehicleTypeList;
    }

    public FeeCalculationStrategyType getFeeCalculationStrategyType() {
        return feeCalculationStrategyType;
    }

    public void setFeeCalculationStrategyType(FeeCalculationStrategyType feeCalculationStrategyType) {
        this.feeCalculationStrategyType = feeCalculationStrategyType;
    }

    public SpotAssignmentStrategyType getSpotAssignmentStrategyType() {
        return spotAssignmentStrategyType;
    }

    public void setSpotAssignmentStrategyType(SpotAssignmentStrategyType spotAssignmentStrategyType) {
        this.spotAssignmentStrategyType = spotAssignmentStrategyType;
    }
}

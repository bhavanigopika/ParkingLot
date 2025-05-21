package parkinglot.models;

import parkinglot.models.enums.ParkingFloorStatus;

import java.util.List;

public class ParkingFloor extends BaseModel {
   private List<ParkingSpot> parkingSpotList;
   private ParkingFloorStatus parkingFloorStatus;
   private int parkingFloorNo;

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public void setParkingSpotList(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }

    public int getParkingFloorNo() {
        return parkingFloorNo;
    }

    public void setParkingFloorNo(int parkingFloorNo) {
        this.parkingFloorNo = parkingFloorNo;
    }
}

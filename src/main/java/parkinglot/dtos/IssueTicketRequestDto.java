package parkinglot.dtos;

import parkinglot.models.enums.VehicleType;

public class IssueTicketRequestDto {
    //dto - dto is wrapper of few attributes that you want what you have
    //E.g.,fakeStoreProductDto - what fake store is returning is different from what I want in my model
    //dto is mode of like dummy models - I will capture my response or request in this and then I will assign it to my actual classes

    //What are all information do you want from the user to be able to create a ticket...
    //from client side, the client only need to tell the basic information to park a vehicle in parking lot not internal information of each object
    //from next time onwards, we are getting this information form client and search in database

    //User not have Gate object but have id of the gate object, so internally through gateId, it gets gate information from database
    //User not have Vehicle object but have id of the vehicle object, so internally through vehicleNumber, it gets vehicle information from database
    private Long gateId;
    private String vehicleOwnerName;
    private String VehicleNumber;
    private VehicleType VehicleType;

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        VehicleType = vehicleType;
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }
}

package parkinglot.repositories;

import parkinglot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLotMap;
    private Long parkingLotId;

    public ParkingLotRepository() {
        parkingLotMap = new HashMap<>();
        parkingLotId = 0L;
    }

    //Through gateId we can get the parking lot information
    public Optional<ParkingLot> findParkingLotByGateId(Long gateId){
        return Optional.ofNullable(parkingLotMap.get(gateId));
    }

    //to save it in-memory db
    public ParkingLot save(ParkingLot parkingLot){
        //set the id
        if(parkingLot.getId() == 0) {
            parkingLotId = parkingLotId + 1;
            parkingLot.setId(parkingLotId);
            parkingLotMap.put(parkingLotId, parkingLot);
            return parkingLot;
        }
        parkingLotMap.put(parkingLot.getId(), parkingLot);
        return parkingLot;

    }


}

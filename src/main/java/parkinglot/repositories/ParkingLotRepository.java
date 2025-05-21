package parkinglot.repositories;

import parkinglot.models.ParkingLot;

import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLotMap;

    //Through gateId we can get the parking lot information
    public Optional<ParkingLot> findParkingLotByGateId(Long gateId){
        return Optional.ofNullable(parkingLotMap.get(gateId));
    }



}

package parkinglot.repositories;

import parkinglot.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    //not actual database here, so use in-memory database here.
    //in-memory means, store it in any data structure
    //Here, let's use map for our use case
    private Map<Long, Gate> gateMap;
    private Long id;//id is here (i.e) gateId

    //whenever someone makes object of gate or initialize an object of gateRepository (i.e)
    //whenever gateRepository is initialized for the first time, then we start from 0
    public GateRepository() {
       gateMap = new HashMap<>();
       id = 0L;
    }

    //now save the gate, allowing to create a new gate
    //This is like upsert(update, insert) operation
    public Gate save(Gate gate) {
        //Here,we do Update, then Insert -> Upsert
        //if gate.getId = 0(id of the gate is 0), it means first ever gate is created. Note: not first gate, first ever gate...So, id = 0
        //earlier we initialize in constructor that id = 0 (i.e) new gate id is created
        if(gate.getId() == 0){
            //insert into hashmap
            id = id + 1;//earlier id will be whatever, it may be 1,2,3...but this time, next new gate is created. I will increment into 1 and set the id, put it into hashmap
            gate.setId(id);//set the id
            gateMap.put(id, gate); //then store the gate into gateMap along with id
            return gate;
        }
        //if id is not 0 (i.e) it is not new gate (i.e) don't set the id as new one, simply get the id and update (i.e) when someone try to update the gate may be operator change(say)
        //then pick the existing one, then put it into the gate object
        gateMap.put(gate.getId(), gate);
        return gate;
    }

    //now if someone wants to get the gate id from anywhere in my code, then do
    //This should return the gate. Let's use Optional to avoid null pointer exception
    /*
    public Optional<Gate> findById(Long gateId){
        if(gateMap.containsKey(gateId)){
            return gateMap.get(gateId);
        }
        //if gateId is not present then return  null.
        return null;
    }*/
    public Optional<Gate> findById(Long gateId){
        if(gateMap.containsKey(gateId)){
            return Optional.of(gateMap.get(gateId));
        }
        //if gateId is not present then return  null
        return Optional.empty();
    }
}

/*
    Gate object. As an object, Gate is already created.
    Every gate has gateId and gate object
    Gate - {gateNumber, gateStatus, gateType, operator}
    say, gateNumber -> 1, gateStatus -> Open, gateType -> Entry, Operator -> {}

    E.g.,
    key -> value
    id -> gate object
    1 -> gate 1, open, entry, operator information
    2 -> gate 2, closed, entry, operator information
    3 -> gate 3, open, exit, operator information

*/

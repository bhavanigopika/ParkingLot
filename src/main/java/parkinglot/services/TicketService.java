package parkinglot.services;

import parkinglot.exceptions.GateNotFoundException;
import parkinglot.exceptions.ParkingLotException;
import parkinglot.factories.SpotAssignmentStrategyFactory;
import parkinglot.models.Gate;
import parkinglot.models.ParkingLot;
import parkinglot.models.ParkingSpot;
import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;
import parkinglot.models.enums.VehicleType;
import parkinglot.repositories.GateRepository;
import parkinglot.repositories.ParkingLotRepository;
import parkinglot.repositories.TicketRepository;
import parkinglot.repositories.VehicleRepository;
import parkinglot.strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    //initialize the gate repository
    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    //should I pass request dto(issueTicketRequestDto) here? No, dtos are mostly for whatever entry point we have
    //Customer give the order in some form. But waiter does not give that particular order to the chef in the same form
    //waiter should tell the separate information to the chef
    //Similarly, pass the parameter separately
    public Ticket issueTicket(Long gateId, String vehicleOwnerName, String vehicleNumber, VehicleType vehicleType ) throws GateNotFoundException, ParkingLotException {
        //Create a ticket then set all the information in ticket, finally return the ticket
        Ticket ticket = new Ticket();

        //set the time, gate, ticket number, vehicle, parking spot attributes - because ticket have these information and also in ticket class(see in models package) we have added these

        //set the current time in the ticket, so during issue ticket we get all the information
        ticket.setEntryTime(new Date());

        /*****************************************************************************************************************************************************/

        //set the gate to the ticket
        //In which gate, this ticket will issue? So, from the gateId, find the information of gate from gate repository
        //set the gate, you get optional of gate, it might be gate or might not be gate
        Optional<Gate> optionalGate = gateRepository.findById(gateId);

        //inside optionalGate bucket check if gate is present or not.
        //if gate is not present then throw an exception because we cannot create a gate here as Gate g = new Gate(); as
        if(optionalGate.isEmpty()){
            throw new GateNotFoundException("Please enter a valid gate number");
        }
        //if Gate is present(not empty), get the gate object from in-memory database
        Gate gate = optionalGate.get();

        //finally, set the gate in ticket
        ticket.setGate(gate);

        /*****************************************************************************************************************************************************/

        //set the vehicle information
        //we have vehicle no, from the vehicle no, get the vehicle information
        Optional<Vehicle> vehicleOptional = vehicleRepository.findByVehicleNumber(vehicleNumber);
        //Initially a new vehicle is null
        Vehicle newVehicle = null;
        if(vehicleOptional.isEmpty()){
            //if vehicle is empty we would not throw an exception, so create a new vehicle and save it in new database. Also, vehicle is keep on coming and park it here.
            //Here the new vehicle is coming to park
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setOwnerName(vehicleOwnerName);
            newVehicle = vehicleRepository.save(vehicle);
        }else{
            //if the vehicle is already present, then just get the information. Also, vehicle is already present in the past
            newVehicle = vehicleOptional.get();
        }

        //finally, set the vehicle in ticket
        ticket.setVehicle(newVehicle);

        /*****************************************************************************************************************************************************/

        //set the ticket number
        ticket.setTicketNumber("ticket_number" + gateId + "_" + ticket.getGate());

        /*****************************************************************************************************************************************************/

        //set the parking spot
        //How you get the parking spot? Using spot assignment strategy type
        //allocate the spot based on cheapest, nearest to elevator, random
        //According to the corresponding type, assign the spot assign strategy type - so, use FACTORY design pattern

        //We have spot assignment strategy type in parking lot class
        //so, get parking lot information from the parking lot repository

        //This would be optional - to avoid null pointer exception
        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.findParkingLotByGateId(gateId);
        if(optionalParkingLot.isEmpty()){
            throw new ParkingLotException("Provide the correct gateId to find out your parking area");
        }
        ParkingLot parkingLot = optionalParkingLot.get();

        //in parameter, I need strategy enum like cheapest, random, nearest_to_elevator - the type present in ParkingLot class. So, get the Parking Lot object from Parking Lot repository
        //From the spot assignment strategy type call the factory, then factory will return the spot assignment strategy
        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(parkingLot.getSpotAssignmentStrategyType());
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(vehicleType, gate);

        //finally set the parkingSpot in ticket
        ticket.setParkingSpot(parkingSpot);

        /*****************************************************************************************************************************************************/

        //now save the ticket in ticket repository then return it
        return ticketRepository.save(ticket);
    }
}

package parkinglot;

import parkinglot.controllers.TicketController;
import parkinglot.dtos.IssueTicketRequestDto;
import parkinglot.dtos.IssueTicketResponseDto;
import parkinglot.dtos.ResponseStatus;
import parkinglot.models.enums.VehicleType;
import parkinglot.repositories.GateRepository;
import parkinglot.repositories.ParkingLotRepository;
import parkinglot.repositories.TicketRepository;
import parkinglot.repositories.VehicleRepository;
import parkinglot.services.TicketService;

public class Client {
    public static void main(String[] args) {
        //get all the repository
        TicketRepository ticketRepository = new TicketRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        //ticket service need all repository
        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, parkingLotRepository, ticketRepository);

        //TicketController need ticket service
        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDto issueTicketRequestDto = new IssueTicketRequestDto();
        issueTicketRequestDto.setGateId(123L);
        issueTicketRequestDto.setVehicleOwnerName("Vidhu");
        issueTicketRequestDto.setVehicleNumber("VI87789");
        issueTicketRequestDto.setVehicleType(VehicleType.CAR);

        IssueTicketResponseDto issueTicketResponseDto = ticketController.issueTicket(issueTicketRequestDto);
        if(issueTicketResponseDto.getResponseStatus() == ResponseStatus.SUCCESS){
            issueTicketResponseDto.getTicket();
            //complete the code
        }else{
            //throw an exception
        }
    }
}

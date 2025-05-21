package parkinglot.controllers;

import parkinglot.dtos.IssueTicketRequestDto;
import parkinglot.dtos.IssueTicketResponseDto;
import parkinglot.dtos.ResponseStatus;
import parkinglot.models.Gate;
import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;
import parkinglot.services.TicketService;

public class TicketController {
    //Goal to issue ticket: Once client asking the ticket, then client calls controller to issue ticket.
    //so, let's create issue ticket method
    //Details we want to issue ticket is Vehicle information, Gate information as
    /*
    public void issueTicket(Vehicle vehicle, Gate gate) {


    }
    */
    //but instead of passing all the parameters, let's create in a dto(data transfer object). Because, in future we might add some more information. In that time, we won't touch ticketController class...
    //changes will do in dto only

    //Similarly, response will get extra information. So return type will be as dto only

    //Do dependency injection of services. So, inject ticketService in TicketController
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto) {
        IssueTicketResponseDto issueTicketResponseDto = new IssueTicketResponseDto();
        try{
            //The following things will return the ticket
           Ticket ticket = ticketService.issueTicket(issueTicketRequestDto.getGateId(), issueTicketRequestDto.getVehicleOwnerName(), issueTicketRequestDto.getVehicleNumber(), issueTicketRequestDto.getVehicleType());
           //set the ticket which I received from the service
           issueTicketResponseDto.setTicket(ticket);
           issueTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }//if error then catch it
        catch(Exception e){
            e.getMessage();
            issueTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return issueTicketResponseDto;

    }
}

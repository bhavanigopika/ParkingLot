package parkinglot.dtos;

import parkinglot.models.Ticket;

public class IssueTicketResponseDto {
    //send back information to the user
    private Ticket ticket;
    private ResponseStatus responseStatus;

    public Ticket getTicket() {
        return ticket;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }
    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

}

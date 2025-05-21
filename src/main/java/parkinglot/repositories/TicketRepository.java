package parkinglot.repositories;

import parkinglot.models.Ticket;

import java.util.Map;

public class TicketRepository {
    Map<Long, Ticket> ticketMap;

    public Ticket save(Ticket ticket){
        ticketMap.put(ticket.getId(), ticket);
        return ticket;
    }
}

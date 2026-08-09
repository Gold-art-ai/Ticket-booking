package com.example.bookingTickets.dto;

import com.example.bookingTickets.model.Ticket;

public class TicketMapper {
    public static Ticket toEntity(TicketRequest r) {
        return new Ticket(null, r.getPassengerName(), r.getDestination(), r.getPrice());
    }

    public static TicketResponse toResponse(Ticket t) {
        return new TicketResponse(t.getId(), t.getPassengerName(), t.getDestination(), t.getPrice());
    }
}

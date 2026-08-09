package com.example.bookingTickets.service;

import com.example.bookingTickets.model.Ticket;
import com.example.bookingTickets.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {

    @Mock
    private TicketRepository repository;

    @InjectMocks
    private TicketService ticketService;

    @Test
    void createTicket_shouldReturnSavedTicket() {
        Ticket ticket = new Ticket(null, "Alice", "NYC", 100.0);
        when(repository.save(ticket)).thenReturn(new Ticket(1L, "Alice", "NYC", 100.0));
        Ticket result = ticketService.createTicket(ticket);
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Alice", result.getPassengerName());
    }
}

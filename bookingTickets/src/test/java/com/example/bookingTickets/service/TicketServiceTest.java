package com.example.bookingTickets.service;

import com.example.bookingTickets.model.Ticket;
import com.example.bookingTickets.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

    @Test
    void getAllTickets_shouldReturnList() {
        when(repository.findAll()).thenReturn(List.of(
                new Ticket(1L, "A", "B", 1.0),
                new Ticket(2L, "C", "D", 2.0)
        ));
        List<Ticket> result = ticketService.getAllTickets();
        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }
}

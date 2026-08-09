package com.example.bookingTickets.service;

import com.example.bookingTickets.model.Ticket;
import com.example.bookingTickets.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {

    @Mock
    private TicketRepository repository;

    @InjectMocks
    private TicketService ticketService;

    @Test
    void createTicket_shouldReturnSavedTicket() {
    }
}

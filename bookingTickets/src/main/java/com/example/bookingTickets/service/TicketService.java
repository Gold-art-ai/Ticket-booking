package com.example.bookingTickets.service;

import com.example.bookingTickets.exception.TicketNotFoundException;
import com.example.bookingTickets.model.Ticket;
import com.example.bookingTickets.repository.TicketRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket createTicket(Ticket ticket){
        return repository.save(ticket);
    }

    public List<Ticket> getAllTickets(){
        return repository.findAll();
    }

    public Optional<Ticket> getTicketById(Long id){
        return repository.findById(id);
    }

    public Ticket getTicketByIdOrThrow(Long id) {
        return repository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));
    }

    public Ticket updateTicket(Long id, Ticket details){
        Ticket ticket = repository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));
        ticket.setPassengerName(details.getPassengerName());
        ticket.setDestination(details.getDestination());
        ticket.setPrice(details.getPrice());
        return repository.save(ticket);
    }

    public void deleteTicket(Long id){
        repository.deleteById(id);
    }
}

package com.example.bookingTickets.controller;
import com.example.bookingTickets.model.Ticket;
import com.example.bookingTickets.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketService service;
    @PostMapping
    public Ticket addTicket(@RequestBody Ticket ticket){
        return service.createTicket(ticket);
    }
    @GetMapping
    public List<Ticket> fetchAll(){
        return service.getAllTickets();
    }
    @GetMapping("/{id}")
    public Ticket fetchById(@PathVariable Long id){
        return service.getTicketById(id).orElse(null);
    }
    @PutMapping("/{id}")
    public Ticket update(@PathVariable Long id, @RequestBody Ticket ticket){
        return service.updateTicket(id,ticket);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteTicket(id);
    }
}

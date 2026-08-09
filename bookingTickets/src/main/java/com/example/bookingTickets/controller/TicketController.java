package com.example.bookingTickets.controller;
import com.example.bookingTickets.dto.TicketMapper;
import com.example.bookingTickets.dto.TicketRequest;
import com.example.bookingTickets.dto.TicketResponse;
import com.example.bookingTickets.model.Ticket;
import com.example.bookingTickets.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping
    public TicketResponse addTicket(@Valid @RequestBody TicketRequest request){
        return TicketMapper.toResponse(service.createTicket(request));
    }
    @GetMapping
    public List<TicketResponse> fetchAll(){
        return service.getAllTickets().stream()
                .map(TicketMapper::toResponse)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public TicketResponse fetchById(@PathVariable Long id){
        return TicketMapper.toResponse(service.getTicketByIdOrThrow(id));
    }
    @PutMapping("/{id}")
    public Ticket update(@PathVariable Long id, @Valid @RequestBody Ticket ticket){
        return service.updateTicket(id,ticket);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.getTicketByIdOrThrow(id);
        service.deleteTicket(id);
    }
}

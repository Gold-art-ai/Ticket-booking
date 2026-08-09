package com.example.bookingTickets.dto;

public class TicketResponse {
    private Long id;
    private String passengerName;
    private String destination;
    private Double price;

    public TicketResponse() {
    }

    public TicketResponse(Long id, String passengerName, String destination, Double price) {
        this.id = id;
        this.passengerName = passengerName;
        this.destination = destination;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

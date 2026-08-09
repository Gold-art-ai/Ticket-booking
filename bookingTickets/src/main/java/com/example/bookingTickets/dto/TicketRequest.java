package com.example.bookingTickets.dto;

public class TicketRequest {
    private String passengerName;
    private String destination;
    private Double price;

    public TicketRequest() {
    }

    public TicketRequest(String passengerName, String destination, Double price) {
        this.passengerName = passengerName;
        this.destination = destination;
        this.price = price;
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

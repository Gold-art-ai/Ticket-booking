package com.example.bookingTickets.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class TicketRequest {
    @NotBlank
    @Size(min = 2, max = 100)
    private String passengerName;
    @NotBlank
    private String destination;
    @NotNull
    @Positive
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

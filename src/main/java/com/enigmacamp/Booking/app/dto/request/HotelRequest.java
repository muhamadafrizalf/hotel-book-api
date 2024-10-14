package com.enigmacamp.Booking.app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelRequest {
    private String id;
    private String name;
    private String address;
    private String description;
    private Double rating;
    private String facilities;
    private double price;
}

package com.enigmacamp.Booking.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelResponse {
    private String name;
    private String address;
    private String description;
    private Double rating;
    private String facilities;
    private double price;
}

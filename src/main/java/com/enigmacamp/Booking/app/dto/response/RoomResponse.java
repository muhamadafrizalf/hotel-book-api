package com.enigmacamp.Booking.app.dto.response;

import com.enigmacamp.Booking.app.constant.AvailabilityStatus;
import com.enigmacamp.Booking.app.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomResponse {
    private Double price;
    private String description;
    private String roomType;
    private AvailabilityStatus availabilityStatus;
    private Hotel hotel;
}

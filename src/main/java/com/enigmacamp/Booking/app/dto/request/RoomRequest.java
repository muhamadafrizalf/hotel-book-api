package com.enigmacamp.Booking.app.dto.request;

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
public class RoomRequest {
    private String id;
    private Double price;
    private String description;
    private String roomType;
    private AvailabilityStatus availabilityStatus;
    private Hotel hotel;
}

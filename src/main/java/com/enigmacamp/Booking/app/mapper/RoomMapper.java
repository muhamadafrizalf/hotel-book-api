package com.enigmacamp.Booking.app.mapper;

import com.enigmacamp.Booking.app.dto.response.RoomResponse;
import com.enigmacamp.Booking.app.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {
    public RoomResponse mapToRoomResponse(Room room) {
        return RoomResponse.builder()
                .roomType(room.getRoomType())
                .availabilityStatus(room.getAvailabilityStatus())
                .hotel(room.getHotel())
                .description(room.getDescription())
                .price(room.getPrice())
                .build();
    }
}

package com.enigmacamp.Booking.app.mapper;

import com.enigmacamp.Booking.app.dto.response.HotelResponse;
import com.enigmacamp.Booking.app.entity.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {
    public HotelResponse mapToHotelResponse(Hotel hotel) {
        return HotelResponse.builder()
                .name(hotel.getName())
                .address(hotel.getAddress())
                .description(hotel.getDescription())
                .price(hotel.getPrice())
                .rating(hotel.getRating())
                .facilities(hotel.getFacilities())
                .build();
    }
}

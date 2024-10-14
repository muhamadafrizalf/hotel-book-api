package com.enigmacamp.Booking.app.service;

import com.enigmacamp.Booking.app.dto.request.HotelRequest;
import com.enigmacamp.Booking.app.dto.request.PagingRequest;
import com.enigmacamp.Booking.app.dto.response.HotelResponse;
import com.enigmacamp.Booking.app.entity.Hotel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HotelService {
    HotelResponse createHotel(HotelRequest request);
    HotelResponse updateHotel(HotelRequest request);
    void deleteHotelById(String id);
    HotelResponse findHotelById(String id);
    Page<Hotel> findAllHotels(PagingRequest request);

}

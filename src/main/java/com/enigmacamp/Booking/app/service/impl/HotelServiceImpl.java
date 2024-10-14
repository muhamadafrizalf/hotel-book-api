package com.enigmacamp.Booking.app.service.impl;

import com.enigmacamp.Booking.app.dto.request.HotelRequest;
import com.enigmacamp.Booking.app.dto.request.PagingRequest;
import com.enigmacamp.Booking.app.dto.response.HotelResponse;
import com.enigmacamp.Booking.app.entity.Hotel;
import com.enigmacamp.Booking.app.mapper.HotelMapper;
import com.enigmacamp.Booking.app.repository.HotelRepository;
import com.enigmacamp.Booking.app.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    @Override
    public HotelResponse createHotel(HotelRequest request) {
        Hotel hotel = Hotel.builder()
                .name(request.getName())
                .address(request.getAddress())
                .description(request.getDescription())
                .price(request.getPrice())
                .rating(request.getRating())
                .facilities(request.getFacilities())
                .createdAt(System.currentTimeMillis())
                .updatedAt(System.currentTimeMillis())
                .build();
        hotelRepository.saveAndFlush(hotel);
        return hotelMapper.mapToHotelResponse(hotel);
    }

    @Override
    public HotelResponse updateHotel(HotelRequest request) {
        Hotel hotel=findByIdOrThrowError(request.getId());
        hotel.setName(request.getName());
        hotel.setAddress(request.getAddress());
        hotel.setDescription(request.getDescription());
        hotel.setPrice(request.getPrice());
        hotel.setRating(request.getRating());
        hotel.setFacilities(request.getFacilities());
        hotel.setUpdatedAt(System.currentTimeMillis());

        hotelRepository.saveAndFlush(hotel);
        return hotelMapper.mapToHotelResponse(hotel);
    }

    @Override
    public void deleteHotelById(String id) {
        Hotel findHotel=findByIdOrThrowError(id);
        hotelRepository.delete(findHotel);

    }

    @Override
    public HotelResponse findHotelById(String id) {
        Hotel findHotel=findByIdOrThrowError(id);
        return hotelMapper.mapToHotelResponse(findHotel);
    }

    @Override
    public Page<Hotel> findAllHotels(PagingRequest request) {
        Pageable pageable= PageRequest.of(request.getPage()-1, request.getSize());
        return hotelRepository.findAll(pageable);
    }

    private Hotel findByIdOrThrowError(String id) {
        Optional<Hotel> hotel= hotelRepository.findById(id);
        return hotel.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"hotel not found"));
    }
}

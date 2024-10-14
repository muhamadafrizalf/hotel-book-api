package com.enigmacamp.Booking.app.controller;

import com.enigmacamp.Booking.app.dto.request.HotelRequest;
import com.enigmacamp.Booking.app.dto.request.PagingRequest;
import com.enigmacamp.Booking.app.dto.response.HotelResponse;
import com.enigmacamp.Booking.app.dto.response.PagingResponse;
import com.enigmacamp.Booking.app.entity.Hotel;
import com.enigmacamp.Booking.app.mapper.PagingMapper;
import com.enigmacamp.Booking.app.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/hotels")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;
    private final PagingMapper pagingMapper;

    @PostMapping
    public ResponseEntity<?> createHotel(@RequestBody HotelRequest request) {
        HotelResponse response=hotelService.createHotel(request);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
    }
    @GetMapping
    public ResponseEntity<?> getAllHotels(@RequestParam(required = false, defaultValue = "1") Integer page,
                                          @RequestParam(required = false, defaultValue = "5") Integer size) {
        PagingRequest request = pagingMapper.mapPagingRequest(page, size);

        Page<Hotel> hotels= hotelService.findAllHotels(request);
        PagingResponse response= pagingMapper.mapPagingResponse(hotels,page,size);
        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHotelById(@PathVariable("id") String id) {
        HotelResponse hotel = hotelService.findHotelById(id);
        return ResponseEntity.status(HttpStatus.OK.value()).body(hotel);
    }

    @PutMapping
    public ResponseEntity<?> updateHotel(@RequestBody HotelRequest request) {
        HotelResponse response=hotelService.updateHotel(request);
        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable String id) {
        hotelService.deleteHotelById(id);
    }

}

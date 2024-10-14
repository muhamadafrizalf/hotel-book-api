package com.enigmacamp.Booking.app.service;

import com.enigmacamp.Booking.app.dto.request.PagingRequest;
import com.enigmacamp.Booking.app.dto.request.RoomRequest;
import com.enigmacamp.Booking.app.dto.response.RoomResponse;
import com.enigmacamp.Booking.app.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface RoomService {
    RoomResponse createRoom(RoomRequest roomRequest);
    RoomResponse updateRoom(RoomRequest roomRequest);
    void deleteRoom(String id);
    RoomResponse getRoom(String id);
    Page<Room> getRooms(PagingRequest pagingRequest);

}

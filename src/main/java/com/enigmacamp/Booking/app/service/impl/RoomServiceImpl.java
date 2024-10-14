package com.enigmacamp.Booking.app.service.impl;

import com.enigmacamp.Booking.app.dto.request.PagingRequest;
import com.enigmacamp.Booking.app.dto.request.RoomRequest;
import com.enigmacamp.Booking.app.dto.response.RoomResponse;
import com.enigmacamp.Booking.app.entity.Room;
import com.enigmacamp.Booking.app.mapper.RoomMapper;
import com.enigmacamp.Booking.app.repository.RoomRepository;
import com.enigmacamp.Booking.app.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;
    @Override
    public RoomResponse createRoom(RoomRequest roomRequest) {
        Room room= Room.builder()
                .roomType(roomRequest.getRoomType())
                .price(roomRequest.getPrice())
                .availabilityStatus(roomRequest.getAvailabilityStatus())
                .hotel(roomRequest.getHotel())
                .description(roomRequest.getDescription())
                .createdAt(System.currentTimeMillis())
                .updatedAt(System.currentTimeMillis())
                .build();
        roomRepository.saveAndFlush(room);
        return roomMapper.mapToRoomResponse(room);
    }

    @Override
    public RoomResponse updateRoom(RoomRequest roomRequest) {
        Room room= findByIdOrThrowError(roomRequest.getId());
        room.setRoomType(roomRequest.getRoomType());
        room.setAvailabilityStatus(roomRequest.getAvailabilityStatus());
        room.setHotel(roomRequest.getHotel());
        room.setDescription(roomRequest.getDescription());
        room.setPrice(roomRequest.getPrice());
        room.setUpdatedAt(System.currentTimeMillis());
        roomRepository.saveAndFlush(room);
        return roomMapper.mapToRoomResponse(room);
    }

    @Override
    public void deleteRoom(String id) {
        findByIdOrThrowError(id);
        roomRepository.deleteById(id);
    }

    @Override
    public RoomResponse getRoom(String id) {
        Room room = findByIdOrThrowError(id);
        return roomMapper.mapToRoomResponse(room);
    }

    @Override
    public Page<Room> getRooms(PagingRequest pagingRequest) {
        Pageable pageable= PageRequest.of(pagingRequest.getPage()-1, pagingRequest.getSize());
        return roomRepository.findAll(pageable);
    }
    private Room findByIdOrThrowError(String id) {
        Optional<Room> room= roomRepository.findById(id);
        return room.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"room not found"));
    }
}

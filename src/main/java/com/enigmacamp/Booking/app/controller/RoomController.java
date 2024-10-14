package com.enigmacamp.Booking.app.controller;

import com.enigmacamp.Booking.app.dto.request.PagingRequest;
import com.enigmacamp.Booking.app.dto.request.RoomRequest;
import com.enigmacamp.Booking.app.dto.response.PagingResponse;
import com.enigmacamp.Booking.app.dto.response.RoomResponse;
import com.enigmacamp.Booking.app.entity.Room;
import com.enigmacamp.Booking.app.mapper.PagingMapper;
import com.enigmacamp.Booking.app.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;
    private final PagingMapper pagingMapper;

    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody RoomRequest roomRequest) {
        RoomResponse response = roomService.createRoom(roomRequest);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
    }
    @GetMapping
    public ResponseEntity<?> getAllRooms(@RequestParam(required = false, defaultValue = "1") Integer page,
                                         @RequestParam(required = false, defaultValue = "5") Integer size) {
        PagingRequest request = pagingMapper.mapPagingRequest(page, size);
        Page<Room> rooms=roomService.getRooms(request);
        PagingResponse response= pagingMapper.mapPagingResponse(rooms, page, size);
        return ResponseEntity.status(HttpStatus.OK.value()).body(response);

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable("id") String id) {
        RoomResponse response= roomService.getRoom(id);
        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    @PutMapping
    public ResponseEntity<?> updateRoom(@RequestBody RoomRequest roomRequest) {
        RoomResponse response = roomService.updateRoom(roomRequest);
        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable("id") String id) {
        roomService.deleteRoom(id);
    }
}

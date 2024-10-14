package com.enigmacamp.Booking.app.controller;

import com.enigmacamp.Booking.app.constant.PathApi;
import com.enigmacamp.Booking.app.dto.request.AuthRequest;
import com.enigmacamp.Booking.app.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PathApi.BasePath.AUTH)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(PathApi.SubBashPath.SIGNIN)
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest){
        String token = authService.login(authRequest);

        return ResponseEntity.ok(token);
    }
}

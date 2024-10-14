package com.enigmacamp.Booking.app.service;

import com.enigmacamp.Booking.app.dto.request.AuthRequest;

public interface AuthService {
    String login(AuthRequest authRequest);
}

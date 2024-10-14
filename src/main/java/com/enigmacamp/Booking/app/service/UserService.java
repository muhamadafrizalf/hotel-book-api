package com.enigmacamp.Booking.app.service;

import com.enigmacamp.Booking.app.entity.UserCredential;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserCredential loadByUserId(String userId);
    UserCredential findByUsername(String username);
}

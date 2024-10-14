package com.enigmacamp.Booking.app.repository;

import com.enigmacamp.Booking.app.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredential,String> {
    Optional<UserCredential> findByUsername(String username);
}

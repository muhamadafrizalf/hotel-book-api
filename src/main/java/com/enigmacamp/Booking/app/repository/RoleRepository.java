package com.enigmacamp.Booking.app.repository;

import com.enigmacamp.Booking.app.constant.ERole;
import com.enigmacamp.Booking.app.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,String> {

    Optional<Role> findByRole(ERole role);
}

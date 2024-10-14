package com.enigmacamp.Booking.app.service.impl;

import com.enigmacamp.Booking.app.constant.ERole;
import com.enigmacamp.Booking.app.entity.Role;
import com.enigmacamp.Booking.app.repository.RoleRepository;
import com.enigmacamp.Booking.app.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role getOrSave(ERole role) {
        Optional<Role> optionalRole = roleRepository.findByRole(role);
        if (optionalRole.isPresent()) return optionalRole.get();
        Role newRole =  Role.builder()
                .role(role)
                .build();
        return roleRepository.saveAndFlush(newRole);
    }
}

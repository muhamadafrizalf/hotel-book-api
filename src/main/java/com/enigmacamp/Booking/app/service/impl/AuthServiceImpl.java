package com.enigmacamp.Booking.app.service.impl;

import com.enigmacamp.Booking.app.constant.ERole;
import com.enigmacamp.Booking.app.dto.request.AuthRequest;
import com.enigmacamp.Booking.app.entity.Role;
import com.enigmacamp.Booking.app.entity.UserCredential;
import com.enigmacamp.Booking.app.repository.UserCredentialRepository;
import com.enigmacamp.Booking.app.security.JwtUtils;
import com.enigmacamp.Booking.app.service.AuthService;
import com.enigmacamp.Booking.app.service.RoleService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final RoleService roleService;
    private final UserCredentialRepository credentialRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Value("${app.hotel-book.username-admin}")
    private String usernameAdmin;

    @Value("${app.hotel-book.password-admin}")
    private String passwordAdmin;

    @PostConstruct
    public void initSuperAdmin(){
        Optional<UserCredential> optionalUserCred = credentialRepository.findByUsername(usernameAdmin);
        if (optionalUserCred.isPresent()) return;

        Role superAdminRole = roleService.getOrSave(ERole.ROLE_SUPER_ADMIN);
        Role adminRole = roleService.getOrSave(ERole.ROLE_ADMIN);
        Role customerRole = roleService.getOrSave(ERole.ROLE_CUSTOMER);

        String hashPassword = passwordEncoder.encode(passwordAdmin);

        UserCredential userCredential = UserCredential.builder()
                .username(usernameAdmin)
                .password(hashPassword)
                .roles(List.of(superAdminRole,adminRole,customerRole))
                .build();
        credentialRepository.saveAndFlush(userCredential);
    }

    @Override
    public String login(AuthRequest authRequest) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(),
                authRequest.getPassword()
        );
        Authentication authenticated = authenticationManager.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(authenticated);
        UserCredential userCredential = (UserCredential) authenticated.getPrincipal();
        return jwtUtils.generateToken(userCredential);
    }
}

package com.enigmacamp.Booking.app.service;

import com.enigmacamp.Booking.app.constant.ERole;
import com.enigmacamp.Booking.app.entity.Role;


public interface RoleService {
    Role getOrSave(ERole role);
}

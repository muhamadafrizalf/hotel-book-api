package com.enigmacamp.Booking.app.entity;

import com.enigmacamp.Booking.app.constant.ERole;
import com.enigmacamp.Booking.app.constant.PathDb;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = PathDb.ROLE)
public class Role extends AuditEntity{
    @Enumerated(EnumType.STRING)
    private ERole role;
}

package com.enigmacamp.Booking.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String address;
    private String description;
    private Double rating;
    private String facilities;
    private double price;

    @Column(name = "updated_at")
    private Long updatedAt;

    @Column(name = "create_at")
    private Long createdAt;
}

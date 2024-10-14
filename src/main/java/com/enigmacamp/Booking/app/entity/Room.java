package com.enigmacamp.Booking.app.entity;

import com.enigmacamp.Booking.app.constant.AvailabilityStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Double price;
    private String description;
    @Column(name = "room_type")
    private String roomType;
    @Column(name = "status")
    private AvailabilityStatus availabilityStatus;
    @Column(name = "created_at")
    private Long createdAt;
    @Column(name = "updated_at")
    private Long updatedAt;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}

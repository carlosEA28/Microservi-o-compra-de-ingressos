package com.example.carlos.inventoryService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID eventId;


    @Column(name = "name")
    private String name;

    @Column(name = "total_capacity")
    private Long totalCapacity;

    @Column(name = "left_capacity")
    private Long leftCapacity;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private VenueEntity venueEntity;

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(Long totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public Long getLeftCapacity() {
        return leftCapacity;
    }

    public void setLeftCapacity(Long leftCapacity) {
        this.leftCapacity = leftCapacity;
    }

    public VenueEntity getVenueEntity() {
        return venueEntity;
    }

    public void setVenueEntity(VenueEntity venueEntity) {
        this.venueEntity = venueEntity;
    }
}

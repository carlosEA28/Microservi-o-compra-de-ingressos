package com.example.carlos.inventoryService.Service;

import com.example.carlos.inventoryService.Entity.EventEntity;
import com.example.carlos.inventoryService.Entity.VenueEntity;
import com.example.carlos.inventoryService.Repository.EventRepository;
import com.example.carlos.inventoryService.Repository.VenueRepository;
import com.example.carlos.inventoryService.Response.EventInventoryResponse;
import com.example.carlos.inventoryService.Response.VenueInventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private VenueRepository venueRepository;

    public List<EventInventoryResponse> getAllEvents() {
        List<EventEntity> events = eventRepository.findAll();

        return events.stream()
                .map(event -> new EventInventoryResponse(
                        event.getName(),    // String name
                        event.getLeftCapacity(), // Long capacity
                        event.getVenueEntity()    // VenueEntity venue
                ))
                .collect(Collectors.toList());
    }

    public VenueInventoryResponse getVenueInfo(UUID venueId) {
        VenueEntity venue = venueRepository.findById(venueId).orElse(null);

        return new VenueInventoryResponse(venue.getVenueId(), venue.getName(), venue.getTotalCapacity());
    }


}

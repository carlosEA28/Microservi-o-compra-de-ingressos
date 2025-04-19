package com.example.carlos.inventoryService.Controller;

import com.example.carlos.inventoryService.Response.EventInventoryResponse;
import com.example.carlos.inventoryService.Response.VenueInventoryResponse;
import com.example.carlos.inventoryService.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class IventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventory/events")
    public ResponseEntity<List<EventInventoryResponse>> inventoryGetAllEvents() {
        var events = inventoryService.getAllEvents();

        return ResponseEntity.ok().body(events);
    }

    @GetMapping("/inventory/venue/{venueId}")
    public ResponseEntity<VenueInventoryResponse> getInventoryById(@PathVariable("venueId") UUID venueId) {
        var venue = inventoryService.getVenueInfo(venueId);

        return ResponseEntity.ok().body(venue);

    }


}

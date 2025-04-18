package com.example.carlos.inventoryService.Response;

import java.util.UUID;

public record VenueInventoryResponse(UUID venueId, String venueName, Long totalCapacity) {
}

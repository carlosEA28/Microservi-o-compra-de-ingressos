package com.example.carlos.inventoryService.Response;

import com.example.carlos.inventoryService.Entity.VenueEntity;

public record EventInventoryResponse(String name, Long capacity, VenueEntity venue) {
}

package com.hildebrando.MaintenancePreventive.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Truck extends Vehicle implements MaintenancePlan {

    private Integer axes;

    @Override
    public Double calculateMaintenanceInterval() {
        // Example implementation for Truck
        return (double) 15000; // Trucks require maintenance every 8000 km
    }

}

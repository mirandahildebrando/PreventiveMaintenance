package com.hildebrando.ManutencaoPreventiva.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Motorcycle extends Vehicle implements MaintenancePlan {

    private Integer cylinderCapacity;

    @Override
    public Double calculateMaintenanceInterval() {

        return (double) 5000;
    }

}

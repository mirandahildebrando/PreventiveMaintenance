package com.hildebrando.ManutencaoPreventiva.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideCar extends Vehicle implements MaintenancePlan {

    private String passangers;

    @Override
    public Double calculateMaintenanceInterval() {
        
        return (double) 10000;
    }

}

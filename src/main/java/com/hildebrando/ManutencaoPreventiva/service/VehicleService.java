package com.hildebrando.ManutencaoPreventiva.service;

import org.springframework.stereotype.Service;

import com.hildebrando.ManutencaoPreventiva.model.MaintenancePlan;
import com.hildebrando.ManutencaoPreventiva.model.Vehicle;
import com.hildebrando.ManutencaoPreventiva.repository.VehicleRepository;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    
        public Vehicle createVehicle (Vehicle vehicle) {
            return vehicleRepository.save(vehicle);
        }

        public Vehicle getVehicleById(Long id) {
            return vehicleRepository.findById(id).orElse(null);
        }

        public Double calculateNextReview(Long vehicleId) {
            Vehicle vehicle = getVehicleById(vehicleId);

            Double interval = ((MaintenancePlan) vehicle).calculateMaintenanceInterval();

            return vehicle.getCurrentMileage() + interval;
        }


}

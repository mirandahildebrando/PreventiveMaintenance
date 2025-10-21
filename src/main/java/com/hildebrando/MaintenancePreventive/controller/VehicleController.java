package com.hildebrando.MaintenancePreventive.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hildebrando.MaintenancePreventive.model.Motorcycle;
import com.hildebrando.MaintenancePreventive.model.RideCar;
import com.hildebrando.MaintenancePreventive.model.Truck;
import com.hildebrando.MaintenancePreventive.model.Vehicle;
import com.hildebrando.MaintenancePreventive.service.VehicleService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController; 

@RestController 
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    
    @PostMapping("/truck")
    public ResponseEntity<Truck> createTruck(@RequestBody Truck truck) {
        Truck newTruck = (Truck) vehicleService.createVehicle(truck);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTruck);
    }

    
    @PostMapping("/ridecar")
    public ResponseEntity<RideCar> createRideCar(@RequestBody RideCar rideCar) {
        RideCar newRideCar = (RideCar) vehicleService.createVehicle(rideCar);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRideCar);
    }

    
    @PostMapping("/motorcycle")
    public ResponseEntity<Motorcycle> createMotorcycle(@RequestBody Motorcycle motorcycle) {
        Motorcycle newMotorcycle = (Motorcycle) vehicleService.createVehicle(motorcycle);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMotorcycle);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        if (vehicle == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(vehicle);
    }
    
    @GetMapping("/{id}/next-review")
    public ResponseEntity<String> getNextReview(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        if (vehicle == null) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        Double nextReviewKm = vehicleService.calculateNextReview(id);
        String response = String.format("A proxima revisao do veiculo com ID %d deve ser feita aos %.2f km.", id, nextReviewKm);

        return ResponseEntity.ok(response);
    }

}

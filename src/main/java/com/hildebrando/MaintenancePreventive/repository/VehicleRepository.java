package com.hildebrando.MaintenancePreventive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hildebrando.MaintenancePreventive.model.Vehicle;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


}

package com.hildebrando.ManutencaoPreventiva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hildebrando.ManutencaoPreventiva.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


}

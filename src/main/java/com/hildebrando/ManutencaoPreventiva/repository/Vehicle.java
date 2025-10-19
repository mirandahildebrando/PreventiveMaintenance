package com.hildebrando.ManutencaoPreventiva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Vehicle extends JpaRepository<Vehicle, Long> {


}

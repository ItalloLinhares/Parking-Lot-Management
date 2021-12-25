package com.parking.management.repository;

import com.parking.management.model.ParkingSpaceModel;
import com.parking.management.parkingSpaceStatus.ParkingSpaceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpaceModel, Long> {
    ParkingSpaceModel findByid(Long id);
}

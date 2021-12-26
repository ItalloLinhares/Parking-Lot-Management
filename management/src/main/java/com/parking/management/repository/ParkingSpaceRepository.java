package com.parking.management.repository;

import com.parking.management.model.ParkingSpace;
import com.parking.management.status.ParkingSpaceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {
    ParkingSpace findByparkingSpaceStatus(ParkingSpaceStatus parkingSpaceStatus);
}

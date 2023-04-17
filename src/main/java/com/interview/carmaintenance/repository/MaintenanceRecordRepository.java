package com.interview.carmaintenance.repository;

import com.interview.carmaintenance.data.MaintenanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaintenanceRecordRepository extends JpaRepository<MaintenanceRecord, String> {
    Optional<MaintenanceRecord> findById(String id);

    Optional<MaintenanceRecord> findByCarId(String id);

}
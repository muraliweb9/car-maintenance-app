package com.interview.carmaintenance.services;

import com.interview.carmaintenance.repository.MaintenanceRecordRepository;
import com.interview.carmaintenance.data.MaintenanceRecord;
import com.interview.carmaintenance.repository.CarRepository;
import com.interview.carmaintenance.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Optional;

@RestController
@RequestMapping("/maintenance")
@Validated
@Slf4j
public class CarMaintenanceService {

    private CarRepository carRepository;

    private LocationRepository locationRepository;

    private MaintenanceRecordRepository maintenanceRecordRepository;

    @Autowired
    public CarMaintenanceService(MaintenanceRecordRepository maintenanceRecordRepository) {
        this.maintenanceRecordRepository = maintenanceRecordRepository;
    }

    public CarMaintenanceService(CarRepository carRepository, LocationRepository locationRepository,
                                 MaintenanceRecordRepository maintenanceRecordRepository) {
        this.carRepository = carRepository;
        this.locationRepository = locationRepository;
        this.maintenanceRecordRepository = maintenanceRecordRepository;
    }

    @GetMapping("maintenancerecords")
    public Iterator<MaintenanceRecord> maintenancerecords() {
        return maintenanceRecordRepository.findAll().iterator();
    }

    @GetMapping("maintenancerecords/{carId}")
    public MaintenanceRecord maintenancerecordsFor(@PathVariable String carId) {
        log.info("Looking up maintenance record for carId {}", carId);
        Optional<MaintenanceRecord> optMaintRec = maintenanceRecordRepository.findByCarId(carId);
        if (optMaintRec.isPresent()) {
            log.info("Found maintenance record for carId {}", carId);
        }
        return optMaintRec.orElse(null);
    }

    @GetMapping("maintenancerecordsTry/{carId}")
    public MaintenanceRecord maintenancerecordsTryFor(@PathVariable String carId) {
        log.info("Looking up maintenance record try for carId {}", carId);
        Optional<MaintenanceRecord> optMaintRec = maintenanceRecordRepository.findByCarId(carId);
        if (optMaintRec.isPresent()) {
            log.info("Found maintenance record try for carId {}", carId);
        }
        return optMaintRec.orElse(null);
    }

}

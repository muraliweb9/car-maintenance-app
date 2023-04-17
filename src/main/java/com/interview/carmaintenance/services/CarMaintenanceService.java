package com.interview.carmaintenance.services;

import com.interview.carmaintenance.repository.MaintenanceRecordRepository;
import com.interview.carmaintenance.data.MaintenanceRecord;
import com.interview.carmaintenance.repository.CarRepository;
import com.interview.carmaintenance.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
@RequestMapping("/maintenance")
@Validated
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
    public Iterator<MaintenanceRecord> cars() {
        return maintenanceRecordRepository.findAll().iterator();
    }



}

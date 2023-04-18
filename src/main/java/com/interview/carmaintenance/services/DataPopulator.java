package com.interview.carmaintenance.services;

import com.interview.carmaintenance.data.ApplicationData;
import com.interview.carmaintenance.repository.MaintenanceRecordRepository;
import com.interview.carmaintenance.repository.CarRepository;
import com.interview.carmaintenance.repository.LocationRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * Helper bean. After construction @PostConstruct the data loaded from application.yml
 * through @ConfigurationProperties is loaded in to the in memory database
 */
@Service
@EnableConfigurationProperties(ApplicationData.class)
public class DataPopulator {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private MaintenanceRecordRepository maintenanceRecordRepository;

    @Autowired
    private ApplicationData applicationData;

    @PostConstruct
    public void populateInMemoryDatabase() {

        // Populate all the locations - load this first
        applicationData.getLocations().stream().forEach((c) -> locationRepository.save(c));

        // Populate all the cars
        applicationData.getCars().stream().forEach((c) -> carRepository.save(c));

        // Populate all the maintenance records
        applicationData.getMaintenanceRecords().stream().forEach((c) -> maintenanceRecordRepository.save(c));

    }
}

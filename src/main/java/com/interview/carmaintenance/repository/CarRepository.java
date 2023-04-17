package com.interview.carmaintenance.repository;


import com.interview.carmaintenance.data.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends CrudRepository<Car, String> {

    Optional<Car> findById(String id);

}
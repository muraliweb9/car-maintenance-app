package com.interview.carmaintenance.repository;


import com.interview.carmaintenance.data.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends CrudRepository<Location, String> {

    Optional<Location> findById(String id);

}
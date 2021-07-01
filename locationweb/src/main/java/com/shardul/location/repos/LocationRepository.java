package com.shardul.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shardul.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}

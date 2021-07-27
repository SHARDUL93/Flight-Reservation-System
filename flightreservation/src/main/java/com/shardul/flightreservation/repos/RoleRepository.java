package com.shardul.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shardul.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}

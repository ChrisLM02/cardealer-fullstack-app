package com.backend.concesionario.interfaces.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.backend.concesionario.entity.Vehicle;

public interface VehicleService {
    ResponseEntity<Vehicle> createVehicle(Vehicle vehicle);

    ResponseEntity<Vehicle> updateVehicle(Vehicle vehicle);

    ResponseEntity<Void> deleteVehicle(Long vehicleId);

    ResponseEntity<Vehicle> getVehicleById(Long vehicleId);

    ResponseEntity<List<Vehicle>> getAllVehicles();
}

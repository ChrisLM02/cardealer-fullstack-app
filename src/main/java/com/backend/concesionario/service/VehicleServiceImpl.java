package com.backend.concesionario.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.concesionario.entity.Vehicle;
import com.backend.concesionario.interfaces.service.VehicleService;
import com.backend.concesionario.repository.VehicleRepository;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService{
    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public ResponseEntity<Vehicle> createVehicle(Vehicle vehicle) {
        Vehicle createdVehicle = vehicleRepository.save(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicle);
    }

    @Override
    public ResponseEntity<Vehicle> updateVehicle(Vehicle vehicle) {
        Vehicle updatedVehicle = vehicleRepository.save(vehicle);
        return ResponseEntity.ok(updatedVehicle);
    }

    @Override
    public ResponseEntity<Void> deleteVehicle(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Vehicle> getVehicleById(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (vehicle != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return ResponseEntity.ok(vehicles);
    }
}

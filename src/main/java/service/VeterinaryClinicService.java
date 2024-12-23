package service;

import entity.VeterinaryClinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VeterinaryClinicRepository;

import java.util.List;

@Service
public class VeterinaryClinicService {
    @Autowired
    private VeterinaryClinicRepository repository;

    public List<VeterinaryClinic> getAllClinics() {
        return repository.findAll();
    }

    public VeterinaryClinic addClinic(VeterinaryClinic clinic) {
        return repository.save(clinic);
    }

    public List<VeterinaryClinic> searchByName(String name) {
        return repository.findByNameContaining(name);
    }

    public List<VeterinaryClinic> findClinicsNearby(double latitude, double longitude, double radius) {
        return repository.findByLocation(latitude, longitude, radius);
    }
}

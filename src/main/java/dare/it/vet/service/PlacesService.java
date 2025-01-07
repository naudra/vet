package dare.it.vet.service;

import dare.it.vet.entity.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dare.it.vet.repository.PlaceRepository;

import java.util.List;

@Service
public class PlacesService {
    @Autowired
    private PlaceRepository repository;

    public List<Place> getAllPlaces() {
        return repository.findAll();
    }

    public Place addClinic(Place clinic) {
        return repository.save(clinic);
    }

    public List<Place> searchByName(String name) {
        return repository.findByNameContaining(name);
    }

    public List<Place> findClinicsNearby(double latitude, double longitude, double radius) {
        return repository.findByLocation(latitude, longitude, radius);
    }
}

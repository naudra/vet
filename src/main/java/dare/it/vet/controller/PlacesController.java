package dare.it.vet.controller;

import dare.it.vet.entity.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dare.it.vet.service.PlacesService;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlacesController {

    @Autowired
    private PlacesService service;


    @GetMapping
    public List<Place> getAll() {
        return service.getAllPlaces();
    }

    @PostMapping
    public Place addPlace(@RequestBody Place clinic) {
        return service.addClinic(clinic);
    }

    @GetMapping("/search")
    public List<Place> searchPlacesByName(@RequestParam String name) {
        return service.searchByName(name);
    }

    @GetMapping("/nearby")
    public List<Place> getPlacesNearby(@RequestParam double latitude,
                                        @RequestParam double longitude,
                                        @RequestParam double radius) {
        return service.findClinicsNearby(latitude, longitude, radius);
    }
}

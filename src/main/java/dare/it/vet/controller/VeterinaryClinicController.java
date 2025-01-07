package dare.it.vet.controller;

import dare.it.vet.entity.VeterinaryClinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dare.it.vet.service.VeterinaryClinicService;

import java.util.List;

@RestController
@RequestMapping("/api/clinics")
public class VeterinaryClinicController {

    @Autowired
    private VeterinaryClinicService service;


    @GetMapping
    public List<VeterinaryClinic> getAllClinics() {
        return service.getAllClinics();
    }

    @PostMapping
    public VeterinaryClinic addClinic(@RequestBody VeterinaryClinic clinic) {
        return service.addClinic(clinic);
    }

    @GetMapping("/search")
    public List<VeterinaryClinic> searchClinics(@RequestParam String name) {
        return service.searchByName(name);
    }

    @GetMapping("/nearby")
    public List<VeterinaryClinic> getClinicsNearby(@RequestParam double latitude,
                                                   @RequestParam double longitude,
                                                   @RequestParam double radius) {
        return service.findClinicsNearby(latitude, longitude, radius);
    }
}

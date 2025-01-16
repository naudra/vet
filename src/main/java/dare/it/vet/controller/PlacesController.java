package dare.it.vet.controller;

import dare.it.vet.entity.Place;
import dare.it.vet.responses.PlaceResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dare.it.vet.service.PlacesService;

import java.util.List;

@RestController
@RequestMapping("/api/places")
@Tag(name = "Places", description = "APIs for managing places and clinics.")
public class PlacesController {

    @Autowired
    private PlacesService service;

    @Operation(summary = "Retrieve all places",
            description = "Fetches a list of all places available in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful retrieval of places list.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PlaceResponse.class)))
    })
    @GetMapping
    public List<PlaceResponse> getAll() {
        return service.getAllPlaces();
    }

    @Operation(summary = "Add a new place",
            description = "Creates a new place or clinic and saves it to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Place successfully created.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Place.class))),
            @ApiResponse(responseCode = "400",
                    description = "Invalid input data.",
                    content = @Content(mediaType = "application/json"))
    })
    @PostMapping
    public Place addPlace(@RequestBody Place clinic) {
        return service.addClinic(clinic);
    }

    @Operation(summary = "Search places by name",
            description = "Fetches a list of places matching the given name.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful retrieval of places matching the name.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Place.class))),
            @ApiResponse(responseCode = "404",
                    description = "No places found matching the given name.",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/search")
    public List<Place> searchPlacesByName(@RequestParam String name) {
        return service.searchByName(name);
    }

    @Operation(summary = "Find places nearby",
            description = "Fetches a list of places within a specified radius from the given latitude and longitude.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful retrieval of nearby places.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Place.class))),
            @ApiResponse(responseCode = "400",
                    description = "Invalid input parameters.",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/nearby")
    public List<Place> getPlacesNearby(@RequestParam double latitude,
                                       @RequestParam double longitude,
                                       @RequestParam double radius) {
        return service.findClinicsNearby(latitude, longitude, radius);
    }
}

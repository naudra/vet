package dare.it.vet.responses;

import dare.it.vet.entity.Place;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PlaceResponse {

    public PlaceResponse(final Place place) {
        this.id = place.getId();
        this.name = place.getName();
        this.address = place.getFormattedAddress();
        this.latitude = place.getLatitude();
        this.longitude = place.getLongitude();
        this.placeType =place.getTypes();
    }

    private long id;
    private long placeId;
    private String name;
    private String address;
    private String placeType;
    private Double latitude;
    private Double longitude;


    public long getId() {
        return id;
    }

    public long getPlaceId() {
        return placeId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPlaceType() {
        return placeType;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}

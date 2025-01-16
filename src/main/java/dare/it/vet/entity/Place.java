package dare.it.vet.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "places")
public class Place {

    public Place(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneNumber;
    private String openingHours;

    @Column(name = "place_id", nullable = false, unique = true)
    private String placeId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "formatted_address", nullable = false, columnDefinition = "TEXT")
    private String formattedAddress;

    @Column(name = "lat", nullable = false)
    private Double latitude;

    @Column(name = "lng", nullable = false)
    private Double longitude;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "user_ratings_total")
    private Integer userRatingsTotal;

    @Column(name = "types", columnDefinition = "TEXT")
    private String types;

    @Column(name = "business_status")
    private String businessStatus;

    @Column(name = "open_now")
    private Boolean openNow;

    public void setId(Long id) {
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setUserRatingsTotal(Integer userRatingsTotal) {
        this.userRatingsTotal = userRatingsTotal;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    public void setOpenNow(Boolean openNow) {
        this.openNow = openNow;
    }

    public Long getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public String getPlaceId() {
        return placeId;
    }

    public String getName() {
        return name;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getRating() {
        return rating;
    }

    public Integer getUserRatingsTotal() {
        return userRatingsTotal;
    }

    public String getTypes() {
        return types;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public Boolean getOpenNow() {
        return openNow;
    }
}

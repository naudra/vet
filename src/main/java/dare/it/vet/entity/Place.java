package dare.it.vet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "places")
public class Place {

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

}

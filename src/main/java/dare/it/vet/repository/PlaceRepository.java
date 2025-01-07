package dare.it.vet.repository;

import dare.it.vet.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    List<Place> findByNameContaining(String name);


    @Query(value = "SELECT * FROM place vc " +
            "WHERE (6371 * acos(cos(radians(:latitude)) * cos(radians(vc.lat)) * " +
            "cos(radians(vc.lon) - radians(:longitude)) + sin(radians(:latitude)) * " +
            "sin(radians(vc.lat)))) <= :radius",
            nativeQuery = true)
    List<Place> findByLocation(@Param("latitude") double latitude,
                               @Param("longitude") double longitude,
                               @Param("radius") double radius);


}

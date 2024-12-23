package repository;

import entity.VeterinaryClinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeterinaryClinicRepository extends JpaRepository<VeterinaryClinic, Long> {
    List<VeterinaryClinic> findByNameContaining(String name);


    @Query(value = "SELECT * FROM veterinary_clinic vc " +
            "WHERE (6371 * acos(cos(radians(:latitude)) * cos(radians(vc.latitude)) * " +
            "cos(radians(vc.longitude) - radians(:longitude)) + sin(radians(:latitude)) * " +
            "sin(radians(vc.latitude)))) <= :radius",
            nativeQuery = true)
    List<VeterinaryClinic> findByLocation(@Param("latitude") double latitude,
                                          @Param("longitude") double longitude,
                                          @Param("radius") double radius);


}

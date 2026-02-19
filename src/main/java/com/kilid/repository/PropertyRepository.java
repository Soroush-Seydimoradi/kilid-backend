package com.kilid.repository;

import com.kilid.entity.Property;
import com.kilid.entity.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.locationtech.jts.geom.Point;
import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findByPriceBetween(Double minPrice, Double maxPrice);

    List<Property> findByPropertyType(PropertyType propertyType);

    @Query(value = "SELECT p.* FROM property p " +
            "JOIN location l ON l.id = p.location_id " +
            "WHERE ST_DWithin(l.coordinates::geography, " +
            "ST_SetSRID(ST_MakePoint(:lng, :lat), 4326)::geography, :radius)",
            nativeQuery = true)
    List<Property> findAllWithinDistance(@Param("lng") double longitude,
                                         @Param("lat") double latitude,
                                         @Param("radius") double radiusMeters);
}
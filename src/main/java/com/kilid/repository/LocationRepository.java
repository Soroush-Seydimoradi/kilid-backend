package com.kilid.repository;

import com.kilid.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.locationtech.jts.geom.Point;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query(value = "SELECT * FROM location l WHERE ST_DWithin(l.coordinates, :point, :radius)", nativeQuery = true)
    List<Location> findNearby(Point point, double radius);
}
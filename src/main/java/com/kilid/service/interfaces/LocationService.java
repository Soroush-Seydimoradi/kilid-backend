package com.kilid.service.interfaces;

import com.kilid.entity.Location;
import java.util.List;
import java.util.Optional;

public interface LocationService {
    Location saveLocation(Location location);
    Optional<Location> getLocationById(Long id);
    List<Location> getAllLocations();
    void deleteLocation(Long id);
}
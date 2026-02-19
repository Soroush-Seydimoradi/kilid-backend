package com.kilid.service.interfaces;

import com.kilid.entity.Property;
import com.kilid.entity.PropertyType;
import java.util.List;
import java.util.Optional;

public interface PropertyService {
    Property saveProperty(Property property);
    Optional<Property> getPropertyById(Long id);
    List<Property> getAllProperties();
    List<Property> getPropertiesByType(PropertyType propertyType);
    void deleteProperty(Long id);

    List<Property> getPropertiesWithinDistance(double longitude, double latitude, double radiusMeters);
}
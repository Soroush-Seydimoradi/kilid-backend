package com.kilid.service.interfaces;

import com.kilid.entity.Feature;
import java.util.List;
import java.util.Optional;

public interface FeatureService {
    Feature saveFeature(Feature feature);
    Optional<Feature> getFeatureById(Long id);
    List<Feature> getAllFeatures();
    void deleteFeature(Long id);
}
package com.kilid.service.impl;

import com.kilid.entity.Feature;
import com.kilid.repository.FeatureRepository;
import com.kilid.service.interfaces.FeatureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepository featureRepository;

    public FeatureServiceImpl(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    @Override
    public Feature saveFeature(Feature feature) {
        return featureRepository.save(feature);
    }

    @Override
    public Optional<Feature> getFeatureById(Long id) {
        return featureRepository.findById(id);
    }

    @Override
    public List<Feature> getAllFeatures() {
        return featureRepository.findAll();
    }

    @Override
    public void deleteFeature(Long id) {
        featureRepository.deleteById(id);
    }
}
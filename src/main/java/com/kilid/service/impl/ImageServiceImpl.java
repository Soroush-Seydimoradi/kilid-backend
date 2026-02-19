package com.kilid.service.impl;

import com.kilid.entity.Image;
import com.kilid.entity.Property;
import com.kilid.repository.ImageRepository;
import com.kilid.service.interfaces.ImageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Optional<Image> getImageById(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public List<Image> getImagesByProperty(Property property) {
        return imageRepository.findByProperty(property);
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}
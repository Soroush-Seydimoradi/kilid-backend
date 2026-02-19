package com.kilid.service.interfaces;

import com.kilid.entity.Image;
import com.kilid.entity.Property;
import java.util.List;
import java.util.Optional;

public interface ImageService {
    Image saveImage(Image image);
    Optional<Image> getImageById(Long id);
    List<Image> getAllImages();
    List<Image> getImagesByProperty(Property property);
    void deleteImage(Long id);
}
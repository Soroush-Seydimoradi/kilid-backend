package com.kilid.controller;

import com.kilid.entity.Image;
import com.kilid.entity.Property;
import com.kilid.service.interfaces.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<Image> createImage(@RequestBody Image image) {
        return ResponseEntity.ok(imageService.saveImage(image));
    }

    @GetMapping
    public ResponseEntity<List<Image>> getAllImages() {
        return ResponseEntity.ok(imageService.getAllImages());
    }

    @GetMapping("/property/{propertyId}")
    public ResponseEntity<List<Image>> getImagesByProperty(@PathVariable Long propertyId) {
        Property property = new Property();
        property.setId(propertyId);
        return ResponseEntity.ok(imageService.getImagesByProperty(property));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}
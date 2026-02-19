package com.kilid.controller;

import com.kilid.entity.Property;
import com.kilid.entity.PropertyType;
import com.kilid.service.interfaces.PropertyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    // ➕ افزودن ملک جدید
    @PostMapping
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        return ResponseEntity.ok(propertyService.saveProperty(property));
    }

    // 📄 دریافت همه ملک‌ها
    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        return ResponseEntity.ok(propertyService.getAllProperties());
    }

    // 🔍 دریافت ملک بر اساس ID
    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Optional<Property> property = propertyService.getPropertyById(id);
        return property.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 🔎 فیلتر بر اساس نوع ملک
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Property>> getPropertiesByType(@PathVariable PropertyType propertyType) {
        return ResponseEntity.ok(propertyService.getPropertiesByType(propertyType));
    }

    // 🗺️ Geo Query: پیدا کردن ملک‌ها در شعاع مشخص
    @GetMapping("/near")
    public ResponseEntity<List<Property>> getNearbyProperties(
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam double radius) {
        return ResponseEntity.ok(propertyService.getPropertiesWithinDistance(lng, lat, radius));
    }

    // 🗑️ حذف ملک
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return ResponseEntity.noContent().build();
    }
}
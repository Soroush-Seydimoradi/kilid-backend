package com.kilid.controller;

import com.kilid.entity.Inquiry;
import com.kilid.entity.Property;
import com.kilid.entity.User;
import com.kilid.service.interfaces.InquiryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inquiries")
public class InquiryController {

    private final InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @PostMapping
    public ResponseEntity<Inquiry> createInquiry(@RequestBody Inquiry inquiry) {
        return ResponseEntity.ok(inquiryService.saveInquiry(inquiry));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Inquiry>> getInquiriesByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return ResponseEntity.ok(inquiryService.getInquiriesByUser(user));
    }

    @GetMapping("/property/{propertyId}")
    public ResponseEntity<List<Inquiry>> getInquiriesByProperty(@PathVariable Long propertyId) {
        Property property = new Property();
        property.setId(propertyId);
        return ResponseEntity.ok(inquiryService.getInquiriesByProperty(property));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInquiry(@PathVariable Long id) {
        inquiryService.deleteInquiry(id);
        return ResponseEntity.noContent().build();
    }
}
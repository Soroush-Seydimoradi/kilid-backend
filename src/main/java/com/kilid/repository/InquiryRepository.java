package com.kilid.repository;

import com.kilid.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

    List<Inquiry> findBySender(User sender);

    List<Inquiry> findByPropertyType(PropertyType propertyType);
}
package com.kilid.repository;

import com.kilid.entity.Inquiry;
import com.kilid.entity.PropertyType;
import com.kilid.entity.User;
import com.kilid.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

    List<Inquiry> findBySender(User sender);

    List<Inquiry> findByPropertyType(PropertyType propertyType);
}
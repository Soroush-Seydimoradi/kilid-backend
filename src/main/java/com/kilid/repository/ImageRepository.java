package com.kilid.repository;

import com.kilid.entity.Image;
import com.kilid.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByProperty(Property property);
}
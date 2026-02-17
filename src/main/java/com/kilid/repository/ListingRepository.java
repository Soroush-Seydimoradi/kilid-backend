package com.kilid.repository;

import com.kilid.entity.Listing;
import com.kilid.entity.ListingStatus;
import com.kilid.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {

    List<Listing> findByUser(User user);

    List<Listing> findByStatus(ListingStatus status);}
package com.kilid.service.interfaces;

import com.kilid.entity.Listing;
import com.kilid.entity.ListingStatus;
import com.kilid.entity.User;
import java.util.List;
import java.util.Optional;

public interface ListingService {
    Listing saveListing(Listing listing);
    Optional<Listing> getListingById(Long id);
    List<Listing> getAllListings();
    List<Listing> getListingsByUser(User user);
    List<Listing> getListingsByStatus(ListingStatus status);
    void deleteListing(Long id);
}
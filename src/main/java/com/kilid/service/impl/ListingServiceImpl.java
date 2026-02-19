package com.kilid.service.impl;

import com.kilid.entity.Listing;
import com.kilid.entity.ListingStatus;
import com.kilid.entity.User;
import com.kilid.repository.ListingRepository;
import com.kilid.service.interfaces.ListingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;

    public ListingServiceImpl(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    @Override
    public Listing saveListing(Listing listing) {
        return listingRepository.save(listing);
    }

    @Override
    public Optional<Listing> getListingById(Long id) {
        return listingRepository.findById(id);
    }

    @Override
    public List<Listing> getAllListings() {
        return listingRepository.findAll();
    }

    @Override
    public List<Listing> getListingsByUser(User user) {
        return listingRepository.findByUser(user);
    }

    @Override
    public List<Listing> getListingsByStatus(ListingStatus status) {
        return listingRepository.findByStatus(status);
    }

    @Override
    public void deleteListing(Long id) {
        listingRepository.deleteById(id);
    }
}
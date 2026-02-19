package com.kilid.service.impl;

import com.kilid.entity.Inquiry;
import com.kilid.entity.User;
import com.kilid.entity.Property;
import com.kilid.repository.InquiryRepository;
import com.kilid.service.interfaces.InquiryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryServiceImpl implements InquiryService {

    private final InquiryRepository inquiryRepository;

    public InquiryServiceImpl(InquiryRepository inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }

    @Override
    public Inquiry saveInquiry(Inquiry inquiry) {
        return inquiryRepository.save(inquiry);
    }


    @Override
    public List<Inquiry> getInquiriesByUser(User sender) {
        return inquiryRepository.findBySender(sender);
    }


    @Override
    public void deleteInquiry(Long id) {
        inquiryRepository.deleteById(id);
    }
}
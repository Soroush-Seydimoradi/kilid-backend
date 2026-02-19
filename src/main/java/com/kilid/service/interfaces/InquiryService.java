package com.kilid.service.interfaces;

import com.kilid.entity.Inquiry;
import com.kilid.entity.User;
import com.kilid.entity.Property;
import java.util.List;

public interface InquiryService {
    Inquiry saveInquiry(Inquiry inquiry);
    List<Inquiry> getInquiriesByUser(User user);
    List<Inquiry> getInquiriesByProperty(Property property);
    void deleteInquiry(Long id);
}
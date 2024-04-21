package com.bitlab.sprint2.service;

import com.bitlab.sprint2.model.ApplicationRequest;
import com.bitlab.sprint2.repository.ApplicationRequestRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationRequestService{

    @Autowired
    private ApplicationRequestRepository applicationRequestRepository;
    public List<ApplicationRequest> getApplicationRequest() {
        return applicationRequestRepository.findAll();
    }
    public List<ApplicationRequest> getHandledAppRequests() {
        return applicationRequestRepository.findAll().stream()
                .filter(ApplicationRequest::isHandled)
                .toList();
    }

}

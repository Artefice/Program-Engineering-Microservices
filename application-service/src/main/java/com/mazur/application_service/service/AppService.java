package com.mazur.application_service.service;

import com.mazur.application_service.model.AdoptionApplication;
import com.mazur.application_service.repository.AppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppService {
    private final AppRepository repository;

    public AdoptionApplication save(AdoptionApplication app) {
        return repository.save(app);
    }

    public Iterable<AdoptionApplication> getAll() {
        return repository.findAll();
    }
}

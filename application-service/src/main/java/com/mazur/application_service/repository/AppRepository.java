package com.mazur.application_service.repository;

import com.mazur.application_service.model.AdoptionApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<AdoptionApplication, Long> {
}

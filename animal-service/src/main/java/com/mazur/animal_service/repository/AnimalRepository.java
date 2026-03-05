package com.mazur.animal_service.repository;

import com.mazur.animal_service.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}

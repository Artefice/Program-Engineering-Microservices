package com.mazur.animal_service.service;

import com.mazur.animal_service.model.Animal;
import com.mazur.animal_service.model.AnimalStatus;
import com.mazur.animal_service.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository repository;

    public Animal updateStatus(Long id, String statusStr) {
        Animal animal = repository.findById(id).orElseThrow();
        animal.setStatus(AnimalStatus.valueOf(statusStr));
        return repository.save(animal);
    }

    public Animal create(Animal animal) {
        return repository.save(animal);
    }

    public Iterable<Animal> getAll() {
        return repository.findAll();
    }

    public Animal getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal not found with id: " + id));
    }
}

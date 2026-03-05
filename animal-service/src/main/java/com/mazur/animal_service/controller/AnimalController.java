package com.mazur.animal_service.controller;

import com.mazur.animal_service.model.Animal;
import com.mazur.animal_service.model.AnimalStatus;
import com.mazur.animal_service.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animals")
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalService service;

    @GetMapping
    public Iterable<Animal> list() {
        return service.getAll();
    }

    @PostMapping
    public Animal create(@RequestBody Animal animal) {
        animal.setStatus(AnimalStatus.AVAILABLE);
        return service.create(animal);
    }

    @GetMapping("/{id}")
    public Animal getById(@PathVariable Long id) {
        return service.getById(id);
    }
}

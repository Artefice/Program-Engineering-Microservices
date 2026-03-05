package com.mazur.application_service.controller;

import com.mazur.application_service.dto.StatusUpdateRequest;
import com.mazur.application_service.model.AdoptionApplication;
import com.mazur.application_service.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class AppController {
    private final AppService service;
    private final RabbitTemplate rabbitTemplate;


    @PostMapping
    public AdoptionApplication createApplication(@RequestBody AdoptionApplication request) {

        request.setStatus("NEW");
        AdoptionApplication saved = service.save(request);

        StatusUpdateRequest mqRequest = new StatusUpdateRequest();
        mqRequest.setAnimalId(request.getAnimalId());
        mqRequest.setNewStatus("PENDING");

        rabbitTemplate.convertAndSend("animal.status.queue", mqRequest);

        return saved;
    }

    @GetMapping
    public Iterable<AdoptionApplication> list() {
        return service.getAll();
    }
}

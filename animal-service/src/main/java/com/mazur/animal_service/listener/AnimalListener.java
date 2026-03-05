package com.mazur.animal_service.listener;

import com.mazur.animal_service.dto.StatusUpdateRequest;
import com.mazur.animal_service.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnimalListener {
    private final AnimalService service;

    @RabbitListener(queues = "animal.status.queue")
    public void handleStatusUpdate(StatusUpdateRequest request) {
        System.out.println("Received status update for animal: " + request.getAnimalId());
        try {
            service.updateStatus(request.getAnimalId(), request.getNewStatus());
        } catch (Exception e) {
            System.err.println("Failed to update animal status: " + e.getMessage());
        }
    }
}

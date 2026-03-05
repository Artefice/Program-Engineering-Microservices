package com.mazur.application_service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StatusUpdateRequest implements Serializable {
    private Long animalId;
    private String newStatus;
}

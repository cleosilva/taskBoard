package com.cleo.taskBoard.dto;

import lombok.Data;

@Data
public class TaskDTO {
    private String title;
    private String description;
    private String assignedTo;
}

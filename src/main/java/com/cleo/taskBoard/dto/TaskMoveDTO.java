package com.cleo.taskBoard.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TaskMoveDTO {
    private UUID newLaneId;
    private Integer newPosition;
}

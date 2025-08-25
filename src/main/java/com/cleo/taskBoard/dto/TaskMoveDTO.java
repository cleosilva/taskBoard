package com.cleo.taskBoard.dto;

import java.util.UUID;

public class TaskMoveDTO {
    private UUID newLaneId;
    private Integer newPosition;

    public UUID getNewLaneId() {
        return newLaneId;
    }

    public void setNewLaneId(UUID newLaneId) {
        this.newLaneId = newLaneId;
    }

    public Integer getNewPosition() {
        return newPosition;
    }

    public void setNewPosition(Integer newPosition) {
        this.newPosition = newPosition;
    }
}

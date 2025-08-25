package com.cleo.taskBoard.controller;

import com.cleo.taskBoard.dto.TaskDTO;
import com.cleo.taskBoard.dto.TaskMoveDTO;
import com.cleo.taskBoard.model.Task;
import com.cleo.taskBoard.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/lanes/{laneId}/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@PathVariable UUID laneId, @RequestBody TaskDTO taskDTO){
        Task newTask = taskService.createOrUpdateTask(laneId, taskDTO);
        return ResponseEntity.ok(newTask);
    }

    @PutMapping("/{taskId}/move")
    public ResponseEntity<Task> moveTask(@PathVariable UUID taskId, @RequestBody TaskMoveDTO taskMoveDTO) {
        Task movedTask = taskService.moveTask(taskId, taskMoveDTO);
        return ResponseEntity.ok(movedTask);
    }
}

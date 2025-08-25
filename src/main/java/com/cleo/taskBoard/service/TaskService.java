package com.cleo.taskBoard.service;

import com.cleo.taskBoard.dto.TaskDTO;
import com.cleo.taskBoard.dto.TaskMoveDTO;
import com.cleo.taskBoard.model.Task;
import com.cleo.taskBoard.repository.LaneRepository;
import com.cleo.taskBoard.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private LaneRepository laneRepository;

    public Task createOrUpdateTask(UUID laneId, TaskDTO taskDTO){
        // Encontra a lane por ID
        return laneRepository.findById(laneId).map(lane -> {
            Task task = new Task();
            task.setTitle(taskDTO.getTitle());
            task.setDescription(taskDTO.getDescription());
            task.setAssignedTo(taskDTO.getAssignedTo());
            task.setLane(lane);
            // Lógica para definir a posição, ex: a última posição da Lane
            return taskRepository.save(task);
        }).orElseThrow(() -> new EntityNotFoundException("Lane não encontrada."));
    }

    public Task moveTask(UUID taskId, TaskMoveDTO taskMoveDTO) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Task não encontrada."));
        laneRepository.findById(taskMoveDTO.getNewLaneId()).ifPresent(newLane -> {
            task.setLane(newLane);
            task.setPosition(taskMoveDTO.getNewPosition());
        });
        return taskRepository.save(task);
        // TODO: Adicionar lógica para reordenar outras tarefas na nova Lane para evitar conflitos de posição.

    }
}

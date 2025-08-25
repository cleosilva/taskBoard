package com.cleo.taskBoard.repository;

import com.cleo.taskBoard.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}

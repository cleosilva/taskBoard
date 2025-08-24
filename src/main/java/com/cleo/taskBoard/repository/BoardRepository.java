package com.cleo.taskBoard.repository;

import com.cleo.taskBoard.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoardRepository extends JpaRepository<Board, UUID> {
}

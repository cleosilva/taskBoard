package com.cleo.taskBoard.repository;

import com.cleo.taskBoard.model.Lane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LaneRepository extends JpaRepository<Lane, UUID> {
}

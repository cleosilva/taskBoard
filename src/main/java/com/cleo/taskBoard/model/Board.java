package com.cleo.taskBoard.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data // Anotação do Lombok para gerar getters, setters, toString, etc.
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)// Garante que a coluna name não poderá ter valores nulos no banco de dados.
    private String name;
    private String description;
    private LocalDateTime createdAt;
}

package com.cleo.taskBoard.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Entity
@Data // Anotação do Lombok para gerar getters, setters, toString, etc.
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)// Garante que a coluna name não poderá ter valores nulos no banco de dados.
    private String name;
    private String description;
    private OffsetDateTime createdAt;
}

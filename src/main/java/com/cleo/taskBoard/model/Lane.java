package com.cleo.taskBoard.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Data
@Table(name = "lane")
public class Lane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String name;
    private Integer position;
    //@ManyToOne: Define um relacionamento muitos-para-um com a entidade Board.
    // Board associada só será carregada do banco de dados quando você explicitamente a acessar, o que melhora a performance.
    @ManyToOne(fetch = FetchType.LAZY)
    // Especifica a coluna que será a chave estrangeira (board_id) na tabela lane.
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

}

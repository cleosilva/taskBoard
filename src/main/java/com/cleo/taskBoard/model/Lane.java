package com.cleo.taskBoard.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
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

    public Lane() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}

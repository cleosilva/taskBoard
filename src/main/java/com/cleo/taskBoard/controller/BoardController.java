package com.cleo.taskBoard.controller;

import com.cleo.taskBoard.dto.BoardDTO;
import com.cleo.taskBoard.model.Board;
import com.cleo.taskBoard.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/boards")
@AllArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<Board> createBoard(@RequestBody BoardDTO boardDTO) {
        Board newBoard = boardService.createBoard(boardDTO);
        return new ResponseEntity<>(newBoard, HttpStatus.CREATED);
    }
}

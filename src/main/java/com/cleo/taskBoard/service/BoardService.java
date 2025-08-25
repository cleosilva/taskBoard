package com.cleo.taskBoard.service;

import com.cleo.taskBoard.dto.BoardDTO;
import com.cleo.taskBoard.model.Board;
import com.cleo.taskBoard.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public Board createBoard(BoardDTO boardDTO) {
        Board board = new Board();
        board.setName(boardDTO.getName());
        board.setDescription(boardDTO.getDescription());
        return boardRepository.save(board);
    };
}

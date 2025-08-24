package com.cleo.taskBoard.service;

import com.cleo.taskBoard.dto.BoardDTO;
import com.cleo.taskBoard.model.Board;
import com.cleo.taskBoard.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
// @AllArgsConstructor: Anotação do Lombok que gera um construtor com todos os campos
// da classe, permitindo a injeção de dependência de forma limpa e segura.
@AllArgsConstructor
public class BoardService {
    private BoardRepository boardRepository;

    public Board createBoard(BoardDTO boardDTO) {
        Board board = new Board();
        board.setName(boardDTO.getName());
        board.setDescription(boardDTO.getDescription());
        return boardRepository.save(board);
    };
}

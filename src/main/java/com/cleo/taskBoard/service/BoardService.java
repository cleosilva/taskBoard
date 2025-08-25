package com.cleo.taskBoard.service;

import com.cleo.taskBoard.dto.BoardDTO;
import com.cleo.taskBoard.model.Board;
import com.cleo.taskBoard.model.Lane;
import com.cleo.taskBoard.repository.BoardRepository;
import com.cleo.taskBoard.repository.LaneRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private LaneRepository laneRepository;

    public Board createBoard(BoardDTO boardDTO) {
        Board board = new Board();
        board.setName(boardDTO.getName());
        board.setDescription(boardDTO.getDescription());
        Board newBoard = boardRepository.save(board);

        List<String> defaultLanesNames = Arrays.asList("A fazer", "Fazendo", "Concluído", "Pausado");

        for (int i = 0; i < defaultLanesNames.size(); i++) {
            Lane lane = new Lane();
            lane.setName(defaultLanesNames.get(i));
            lane.setPosition(i);
            lane.setBoard(newBoard);
            laneRepository.save(lane);
        }
        return newBoard;
    };
}

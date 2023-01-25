package com.example.clmate.service;

import com.example.clmate.dto.BoardReqDTO;
import com.example.clmate.dto.BoardResDTO;
import com.example.clmate.entity.BoardEntity;
import com.example.clmate.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardResDTO merge(BoardReqDTO req){
        BoardEntity be = req.toEntity();
        be = boardRepository.save(be);

        return BoardResDTO.builder()
                        .words(be.getWords())
                        .build();
    }

    public List<BoardResDTO> selectAll(){
        List<BoardEntity> result = boardRepository.findAll();
        List<BoardResDTO> resList = result.stream()
                                    .map(be -> BoardResDTO.builder()
                                            .words(be.getWords())
                                            .build())
                                    .collect(Collectors.toList());

        return resList;
    }

    public List<BoardResDTO> selectWordsByEmail(BoardReqDTO dto){
        List<BoardEntity> result = boardRepository.findByEmail(dto.getEmail());
        List<BoardResDTO> resList = result.stream()
                                    .map(be -> BoardResDTO.builder()
                                           .words(be.getWords())
                                           .build())
                                    .collect(Collectors.toList());

        return resList;
    }

    public String deleteByEmailAndId(BoardReqDTO req){

        boardRepository.deleteByEmailAndId(req);

        return "Your words are successfully deleted!!!";
    }
}

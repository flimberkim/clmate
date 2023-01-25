package com.example.clmate.controller;

import com.example.clmate.dto.BoardReqDTO;
import com.example.clmate.dto.BoardResDTO;
import com.example.clmate.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.modelmbean.ModelMBeanNotificationBroadcaster;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/insertWords")
    public BoardResDTO mergeWords(){
        BoardReqDTO req = BoardReqDTO.builder()
                        .email("khaha@naver.com")
                        .words("안녕하세요! 질문이 있어 게시판에 글 올립니다.")
                        .build();

        return boardService.merge(req);
    }

    @GetMapping("/selectAllWords")
    public List<BoardResDTO> selectAll(){
        return boardService.selectAll();
    }

    @GetMapping("/selectWordsByEmail")
    public List<BoardResDTO> selectWordsByEmail(){
        return boardService.selectWordsByEmail(BoardReqDTO.builder()
                                                        .email("khaha@naver.com")
                                                        .build());
    }

    @GetMapping("deleteByEmailAndId")
    public String deleteByEmailAndId(){

        return boardService.deleteByEmailAndId(BoardReqDTO.builder()
                                                    .email("khaha@naver.com")
                                                    .id(1L)
                                                    .build());

    }
}

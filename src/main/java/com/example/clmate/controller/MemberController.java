package com.example.clmate.controller;

import com.example.clmate.dto.MemberReqDTO;
import com.example.clmate.dto.MemberResDTO;
import com.example.clmate.service.BoardService;
import com.example.clmate.service.MemberService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Builder
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/insert")
    public MemberResDTO mergeMemberEntity(){
        MemberReqDTO dto = MemberReqDTO.builder()
                            .email("clmate1@naver.com")
                            .password("1234")
                            .name("김개똥")
                            .phone("010-1111-2222")
                            .address("서울시 강남구")
                            .build();

        return memberService.merge(dto);
    }

    @GetMapping("/selectAll")
    public List<MemberResDTO> selectAll(){
        return memberService.selectAll();
    }

    @GetMapping("/selectById")
    public MemberResDTO selectById(){
        return memberService.selectOne(MemberReqDTO.builder()
                                                    .email("clmate8@naver.com")
                                                    .build());
    }

    @GetMapping("/selectByName")
    public List<MemberResDTO> selectByName(){
        MemberReqDTO dto = MemberReqDTO.builder()
                                    .name("전형진")
                                    .build();
        return memberService.selectByName(dto);
    }

    @GetMapping("/deleteAll")
    public String deleteAll(){
        memberService.deleteAll();
        return "All data is deleted!";
    }

    @GetMapping("/deleteByEmail")
    public String deleteByEmail(){
        memberService.deleteByEmail(MemberReqDTO.builder()
                                                .email("khaha@naver.com")
                                                .build());
        return "Your data is successfully deleted!";
    }

}

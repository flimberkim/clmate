package com.example.clmate.service;

import com.example.clmate.dto.MemberReqDTO;
import com.example.clmate.dto.MemberResDTO;
import com.example.clmate.entity.MemberEntity;
import com.example.clmate.repository.MemberRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResDTO merge(MemberReqDTO req){ //DB에 회원정보를 넣음
        MemberEntity me = req.toEntity();
        me = memberRepository.save(me);

        return MemberResDTO.builder()
                .email(me.getEmail())
                .name(me.getName())
                .build();
    }

    public List<MemberResDTO> selectAll(){
        List<MemberEntity> result = memberRepository.findAll();
        List<MemberResDTO> resList = result.stream()
                                    .map(me -> MemberResDTO.builder()
                                                .email(me.getEmail())
                                                .name(me.getName())
                                                .build())
                                    .collect(Collectors.toList());

        return resList;
    }

    public MemberResDTO selectOne(MemberReqDTO req){

        MemberEntity me = memberRepository.findById(req.getEmail()).orElse(null);

        return MemberResDTO.builder()
                            .email(me.getEmail())
                            .name(me.getName())
                            .build();
    }

    public List<MemberResDTO> selectByName(MemberReqDTO dto){
        List<MemberEntity> result = memberRepository.findByName(dto.getName());

        List<MemberResDTO> resList = result.stream()
                .map(me -> MemberResDTO.builder()
                            .email(me.getEmail())
                            .name(me.getName())
                            .build())
                .collect(Collectors.toList());

        return resList;
    }

    public void deleteAll(){
        memberRepository.deleteAll();
    }

    public void deleteByEmail(MemberReqDTO req){
        memberRepository.deleteById(req.getEmail());
    }



}

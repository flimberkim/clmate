package com.example.clmate.repository;

import com.example.clmate.dto.BoardReqDTO;
import com.example.clmate.entity.BoardEntity;
import com.example.clmate.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    public List<BoardEntity> findByEmail(String email);

    public String deleteByEmailAndId(BoardReqDTO req);
}

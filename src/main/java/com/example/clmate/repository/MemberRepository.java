package com.example.clmate.repository;

import com.example.clmate.dto.MemberResDTO;
import com.example.clmate.entity.MemberEntity;
import com.sun.tools.javac.parser.JavacParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> {

    public List<MemberEntity> findByName(String name);
}

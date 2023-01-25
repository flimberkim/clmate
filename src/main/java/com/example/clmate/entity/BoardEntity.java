package com.example.clmate.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor //모든 인자를 받는 생성자
@NoArgsConstructor //기본생성자
@Entity
@Getter
@Setter
@Builder
@Table(name = "board") //매칭되는 '테이블'의 이름을 적어준다.
public class BoardEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, length = 40)
    private String email;

    @Column(name = "words")
    private String words;

}

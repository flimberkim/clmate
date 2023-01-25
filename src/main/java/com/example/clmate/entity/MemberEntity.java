package com.example.clmate.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor //모든 인자를 받는 생성자
@NoArgsConstructor //기본생성자
@Entity
@Getter
@Setter
@Builder
@Table(name = "clmatemember") //매칭되는 '테이블'의 이름을 적어준다.
public class MemberEntity {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "address", nullable = false, length = 50)
    private String address;

}

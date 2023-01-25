package com.example.clmate.dto;

import com.example.clmate.entity.MemberEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberReqDTO {

    private String email;

    private String password;

    private String name;

    private String phone;

    private String address;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .email(email)
                .password(password)
                .name(name)
                .phone(phone)
                .address(address)
                .build();
    }
}

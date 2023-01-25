package com.example.clmate.dto;

import com.example.clmate.entity.BoardEntity;
import lombok.*;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardReqDTO {

    private Long id;

    private String email;

    private String words;

    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .id(id)
                .email(email)
                .words(words)
                .build();
    }


}

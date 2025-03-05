package com.studyGuide.project.dtos;

import com.studyGuide.project.entitys.Answers;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDto {
    private Long id;
    private String text;

    public AnswerDto(Answers answer){
        this.id = answer.getId();
        this.text = answer.getText();

    }

}

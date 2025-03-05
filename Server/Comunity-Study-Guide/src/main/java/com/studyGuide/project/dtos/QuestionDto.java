package com.studyGuide.project.dtos;

import com.studyGuide.project.entitys.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class QuestionDto {
    private Long id;
    private String topic;
    private String content;
    private List<AnswerDto> answers;

    public QuestionDto(Question question) {
        this.id = question.getId();
        this.topic = question.getTopic();
        this.content = question.getContent();
        this.answers = question.getAnswers().stream().map(AnswerDto::new).toList();
    }
}
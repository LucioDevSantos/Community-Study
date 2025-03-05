package com.studyGuide.project.controllers;



import com.studyGuide.project.dtos.QuestionDto;
import com.studyGuide.project.entitys.Question;
import com.studyGuide.project.repositories.QuestionRepo;
import com.studyGuide.project.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionsController {

    // Repositories
    @Autowired
    private QuestionRepo questionRepo;

    // Services
    @Autowired
    private QuestionService questionServices;

    @GetMapping("/questions")
    public List<QuestionDto> getQuestions(){
        List<Question> questions = questionRepo.findAll();
    return questions.stream().map(QuestionDto::new).toList();
    }

    @PostMapping("/question")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question){
       return ResponseEntity.status(HttpStatus.OK).body(questionServices.SaveOpenService(question));
    }

    @GetMapping("/questions/{content}")
    public ResponseEntity<List<QuestionDto>> searchQuestions(@PathVariable String content){
        return ResponseEntity.status(HttpStatus.OK).body(questionServices.findQuestion(content));
    }

    @PostMapping("/question/{id}/answer")
    public QuestionDto addAnswer(@PathVariable Long id, @RequestBody String text){
        return questionServices.AddAnswer(id, text);
    }
}

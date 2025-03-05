package com.studyGuide.project.services;



import com.studyGuide.project.dtos.QuestionDto;
import com.studyGuide.project.entitys.Answers;
import com.studyGuide.project.entitys.Question;
import com.studyGuide.project.repositories.AnswerRepo;
import com.studyGuide.project.repositories.QuestionRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    // Repositories
    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private AnswerRepo answerRepo;

    @Autowired
    private EntityManager entityManager;

    public Question SaveOpenService(Question Question){
        return questionRepo.save(Question);
    }


    public QuestionDto AddAnswer(Long id, String text){

        Question question = questionRepo.findById(id).orElseThrow(() -> new RuntimeException("no Question Found :/"));
        Answers answers = new Answers();

        answers.setText(text);
        answers.setQuestion(question);
        var saved = answerRepo.save(answers);

        question.getAnswers().add(saved);

        return new QuestionDto(question);


    }

    @SuppressWarnings("unchecked")
    public List<QuestionDto> findQuestion(String content) {
        List<Question> result = entityManager.createNativeQuery("SELECT id, topic, content, MATCH(topic, content) AGAINST(:content) as score FROM questions WHERE MATCH(topic, content) AGAINST(:content)", Question.class).setParameter("content", content).getResultList();
    return result.stream().map(QuestionDto::new).toList();
    }

}

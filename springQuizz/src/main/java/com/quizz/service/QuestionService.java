package com.quizz.service;

import com.quizz.model.QuestionModel;
import com.quizz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    public List<QuestionModel> getAllQuestionDetails(String category) {

        return questionRepository.getDetailsByCategory(category);
    }

    public List<QuestionModel> getAllQuestions() {

        return (List<QuestionModel>) questionRepository.findAll();

    }

    public ResponseEntity<String> addQuestion(QuestionModel model){
        questionRepository.save(model);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

}

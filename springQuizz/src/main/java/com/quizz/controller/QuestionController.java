package com.quizz.controller;

import com.quizz.model.QuestionModel;
import com.quizz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/get")
    public List<QuestionModel> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/get/{category}")
    public List<QuestionModel> getAllQuestionsByCategory(@PathVariable String category){
        return questionService.getAllQuestionDetails(category);
    }

    @PostMapping("/save")
    public ResponseEntity<String> postQuestion(@RequestBody QuestionModel model){
        return questionService.addQuestion(model);
    }
}

package com.quizz.service;

import com.quizz.model.QuestionModel;
import com.quizz.model.QuestionWrapper;
import com.quizz.model.QuizModel;
import com.quizz.model.Response;
import com.quizz.repository.QuestionRepository;
import com.quizz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<QuestionModel> questions = questionRepository.selectQuestionsByRandomly(category,numQ);

        QuizModel quizModel = new QuizModel();

        quizModel.setTitle(title);
        quizModel.setQuestions(questions);
        quizRepository.save(quizModel);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {

        Optional<QuizModel> quizModel = quizRepository.findById(id);
        List<QuestionModel> questionsFromDB =quizModel.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for(QuestionModel  q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> responses){
        QuizModel model = quizRepository.findById(id).get();
        List<QuestionModel> questionModel = model.getQuestions();
        int right=0;
        int i=0;
        for(Response response: responses){
            if(response.getResponse().equals(questionModel.get(i).getRightAnswer()))

                right++;
            i++;

        }
        return new ResponseEntity<>(right,HttpStatus.OK);

    }
}

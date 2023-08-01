package com.quizz.repository;

import com.quizz.model.QuizModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends CrudRepository<QuizModel,Integer> {
}

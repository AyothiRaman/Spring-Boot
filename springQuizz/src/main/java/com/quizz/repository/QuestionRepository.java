package com.quizz.repository;

import com.quizz.model.QuestionModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionModel,Integer> {
    public List<QuestionModel> getDetailsByCategory(String category) ;

    @Query(value = "Select * from Question_Details q where q.category=:category order by Random() Limit :numQ",nativeQuery = true)
    List<QuestionModel> selectQuestionsByRandomly(String category, int numQ);
}

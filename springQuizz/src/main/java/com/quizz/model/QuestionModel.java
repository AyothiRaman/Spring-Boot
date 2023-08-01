package com.quizz.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Question_Details")
@Data
public class QuestionModel {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String category;
    private String difficultyLevel;
    private String rightAnswer;

}

package com.woobot.quizservice.model;

import lombok.Data;

@Data
public class QuizDto {
    private String category;
    private int questionsNumber;
    private String title;
}

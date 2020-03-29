package com.github.christopheleblond.backend.services;

import com.github.christopheleblond.backend.model.Quizz;

import java.util.List;

public interface QuizzService {

    List<Quizz> findAllQuizz();

    Quizz findQuizzById(long quizzId);
}

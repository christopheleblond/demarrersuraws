package com.github.christopheleblond.backend.services.impl;

import com.github.christopheleblond.backend.model.Quizz;
import com.github.christopheleblond.backend.services.QuizzService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizzServiceImpl implements QuizzService {

    @Override
    public List<Quizz> findAllQuizz() {
        return null;
    }

    @Override
    public Quizz findQuizzById(long quizzId) {
        return null;
    }
}

package com.github.christopheleblond.backend.services;

import com.github.christopheleblond.backend.model.QuizzSession;

public interface QuizzSessionService {

    QuizzSession newSession(String username, String registrationId);

    QuizzSession answer(QuizzSession session, int answerIndex);
}

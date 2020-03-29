package com.github.christopheleblond.backend.services.impl;

import com.github.christopheleblond.backend.model.*;
import com.github.christopheleblond.backend.services.QuizzSessionService;
import org.springframework.stereotype.Service;

@Service
public class QuizzSessionServiceImpl implements QuizzSessionService {

    @Override
    public QuizzSession newSession(String username, String registrationId) {

        QuizzSession session = new QuizzSession();
        session.setRegistration(new Registration(username));

        return session;
    }

    @Override
    public QuizzSession answer(QuizzSession session, int answerIndex) {

        if(session.getQuizz() == null) {
            throw new IllegalArgumentException("No quizz selected");
        }

        Quizz quizz = session.getQuizz();

        Question question = null;

        try{
            question = quizz.getQuestions().get(session.getCurrentQuestionIndex());

        }catch (ArrayIndexOutOfBoundsException ae) {
            throw new IllegalStateException("Current quizz has no question with index " + session.getCurrentQuestionIndex());
        }


        Answer answer = null;
        try {
            answer = question.getAnswers().get(answerIndex);

        }catch (ArrayIndexOutOfBoundsException ae) {
            throw new IllegalArgumentException("Current question has no answer with index " + answer);
        }

        // Save answer

        if(session.getCurrentQuestionIndex() == (quizz.getQuestions().size() - 1)) {
            // last question
            session.setState(QuizzSession.SessionState.FINISHED);

            // Eval score
            session.setCurrentScore(111);

        } else {
            session.setCurrentQuestionIndex(session.getCurrentQuestionIndex() + 1);
        }


        return session;
    }
}

package com.github.christopheleblond.backend.model;

public class QuizzSession {

    private String sessionId;

    private Quizz quizz;

    private int currentQuestionIndex = 0;

    private int currentScore = 0;

    private Registration registration;

    private SessionState state = SessionState.NONE;

    public QuizzSession() {
        this.state = SessionState.CREATED;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Quizz getQuizz() {
        return quizz;
    }

    public void setQuizz(Quizz quizz) {
        this.quizz = quizz;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public SessionState getState() {
        return state;
    }

    public void setState(SessionState state) {
        this.state = state;
    }

    public enum SessionState {
        NONE,
        CREATED,
        RUNNING,
        FINISHED
    }
}

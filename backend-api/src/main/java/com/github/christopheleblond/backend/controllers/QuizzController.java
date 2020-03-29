package com.github.christopheleblond.backend.controllers;

import com.github.christopheleblond.backend.model.*;
import com.github.christopheleblond.backend.services.QuizzService;
import com.github.christopheleblond.backend.services.QuizzSessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuizzController {

    public static final String X_QUIZZ_REGISTRATION_ID = "X-Quizz-Registration-Id";

    public static final String X_QUIZZ_SESSION_ID = "X-Quizz-Session-Id";

    public static final Logger LOGGER = LoggerFactory.getLogger(QuizzController.class);

    private QuizzSessionService quizzSessionService;

    private QuizzService quizzService;

    public QuizzController(QuizzService quizzService, QuizzSessionService quizzSessionService) {
        this.quizzService = quizzService;
        this.quizzSessionService = quizzSessionService;
    }

    @PostMapping("/register")
    public QuizzSession registerUser(@RequestParam("username") String username,
                                     @RequestHeader(X_QUIZZ_REGISTRATION_ID) @DefaultValue("") String registrationId) {

        LOGGER.debug("registerUser: {}", username);

        QuizzSession session = null;

        return quizzSessionService.newSession(username, registrationId);
    }

    @GetMapping("/quizz")
    public List<Quizz> findAllQuizz() {
        return new ArrayList<>();
    }

    @GetMapping("/quizz/{quizzId}")
    public Quizz findQuizzById(@PathVariable("quizzId") long quizzId) {
        return null;
    }

    @PostMapping("/quizz/{quizzId}/start")
    public QuizzSession start(@PathVariable long quizzId, @RequestHeader("X-Quizz-Registration") String registrationId) {

        LOGGER.debug("start Quizz: {}", quizzId);

        return null;
    }

    public QuizzSession answer(@PathVariable long quizzId, @RequestHeader("X-Quizz-Registration") String registrationId, @RequestBody Answer answer) {
        return null;
    }
}

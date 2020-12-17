package ch.bemyquarantine.bmqapi.persistance;

import ch.bemyquarantine.bmqapi.attitude.Answer;

public interface CustomizedAnswerRepo {
    Answer getOrCreate(AnswerRepo answerRepo, Answer answer);
}

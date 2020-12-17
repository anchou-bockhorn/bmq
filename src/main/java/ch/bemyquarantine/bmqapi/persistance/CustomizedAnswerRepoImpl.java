package ch.bemyquarantine.bmqapi.persistance;

import ch.bemyquarantine.bmqapi.attitude.Answer;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

@Repository
public class CustomizedAnswerRepoImpl implements CustomizedAnswerRepo {
/*
    private final AnswerRepo answerRepo;

    public CustomizedAnswerRepoImpl(AnswerRepo answerRepo) {
        this.answerRepo = answerRepo;
    }
*/

    public Answer getOrCreate(AnswerRepo answerRepo, Answer answer) {
        return answerRepo
                .findOne(Example.of(answer))
                .orElseGet(() -> answerRepo.insert(answer));
    }
}

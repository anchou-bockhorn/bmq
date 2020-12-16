package ch.bemyquarantine.bmqapi.http;

import ch.bemyquarantine.bmqapi.attitude.Answer;
import ch.bemyquarantine.bmqapi.persistance.AnswerRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
public class HttpAnswer {

    private final AnswerRepo answerRepo;

    public HttpAnswer(AnswerRepo answerRepo) {
        this.answerRepo = answerRepo;
    }

    @GetMapping("/answer")
    public List<Answer> answers() {
        return answerRepo.findAll();
    }

    @GetMapping("/answer/{id}")
    public Optional<Answer> answer(@PathVariable String id) {
        return answerRepo.findById(new BigInteger(id));
    }

    @PostMapping("/answer")
    @ResponseStatus(HttpStatus.CREATED)
    public Answer createAnswer(@RequestBody Answer answer) {
        return answerRepo.insert(answer);
    }

    @DeleteMapping("/answer/{id}")
    public void deleteAnswer(@PathVariable String id) {
        answerRepo.findById(new BigInteger(id)).ifPresent(answerRepo::delete);
    }
}

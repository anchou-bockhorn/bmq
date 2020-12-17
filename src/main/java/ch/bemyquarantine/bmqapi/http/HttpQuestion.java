package ch.bemyquarantine.bmqapi.http;

import ch.bemyquarantine.bmqapi.attitude.Answer;
import ch.bemyquarantine.bmqapi.attitude.Question;
import ch.bemyquarantine.bmqapi.persistance.AnswerRepo;
import ch.bemyquarantine.bmqapi.persistance.QuestionRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class HttpQuestion {
    private final QuestionRepo questionRepo;
    private final AnswerRepo answerRepo;

    public HttpQuestion(QuestionRepo questionRepo, AnswerRepo answerRepo) {
        this.questionRepo = questionRepo;
        this.answerRepo = answerRepo;
    }

    @GetMapping("/question")
    public List<Question> questions() {
        return questionRepo.findAll();
    }

    @GetMapping("/question/{id}")
    public Optional<Question> question(@PathVariable String id) {
        return questionRepo.findById(new BigInteger(id));
    }

    @PostMapping("/question")
    @ResponseStatus(HttpStatus.CREATED)
    public Question createQuestion(@RequestBody Question question) {
        Set<Answer> answers = question.getAnswers()
                .stream()
                .map(requestedAnswer -> answerRepo.getOrCreate(answerRepo, requestedAnswer))
                .collect(Collectors.toSet());
        question.setAnswers(answers);

        return questionRepo.insert(question);
    }
/*

    @PutMapping("/question/{id}")
    public Question updateQuestion(@PathVariable String id, @RequestBody Question question) {
        return questionRepo.findById(new BigInteger(id))
                .map(u -> questionRepo.save(u.update(question)))
                .orElseThrow(() -> new ResourceNotFoundException("Question with id:'" + id + "' not found"));
    }
*/

    @DeleteMapping("/question/{id}")
    public void deleteQuestion(@PathVariable String id) {
        questionRepo.findById(new BigInteger(id)).ifPresent(questionRepo::delete);
    }
}

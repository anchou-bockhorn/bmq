package ch.bemyquarantine.bmqapi.persistance;

import ch.bemyquarantine.bmqapi.attitude.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface AnswerRepo extends MongoRepository<Answer, BigInteger> {
}

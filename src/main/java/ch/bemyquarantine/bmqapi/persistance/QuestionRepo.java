package ch.bemyquarantine.bmqapi.persistance;

import ch.bemyquarantine.bmqapi.attitude.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface QuestionRepo extends MongoRepository<Question, BigInteger> {
}

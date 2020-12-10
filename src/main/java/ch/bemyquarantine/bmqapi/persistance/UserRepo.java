package ch.bemyquarantine.bmqapi.persistance;

import ch.bemyquarantine.bmqapi.user.UserDetail;
import com.mongodb.client.model.geojson.Point;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface UserRepo extends MongoRepository<UserDetail, BigInteger> {

    GeoResults<UserDetail> findByResidenceNear(Point p, Distance d);
}

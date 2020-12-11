package ch.bemyquarantine.bmqapi.persistance;

import ch.bemyquarantine.bmqapi.user.Gender;
import ch.bemyquarantine.bmqapi.user.RelationTyp;
import ch.bemyquarantine.bmqapi.user.User;
import com.mongodb.client.model.geojson.NamedCoordinateReferenceSystem;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Configuration
public class Setup {
    @Bean
    InitializingBean seedDb(UserRepo userRepo) {
        return () -> {
            userRepo.deleteAll();
/*
            userRepo.save(new User()
                    .setActive(true)
                    .setDateOfBirth(new GregorianCalendar(1994, Calendar.AUGUST, 17).getTime())
                    .setGender(Gender.MALE)
                    .setRelationTyp(RelationTyp.POLYGAMOUS)
//                    .setResidence(new Point(NamedCoordinateReferenceSystem.CRS_84, new Position(-73.564453125, 42.114523952464246)))
                    .setUsername("Rabia"));

            User user2 = new User()
                    .setActive(true)
                    .setDateOfBirth(new GregorianCalendar(1991, Calendar.NOVEMBER, 28).getTime())
                    .setGender(Gender.MALE)
                    .setRelationTyp(RelationTyp.POLYGAMOUS)
//                    .setResidence(new Point(NamedCoordinateReferenceSystem.CRS_84, new Position(-73.264453125, 42.214523952464246)))
                    .setUsername("Julio");
            userRepo.save(user2);
*/
        };
    }

    @Bean
    CommandLineRunner exampleQuery(UserRepo userRepo) {
        Point p = new Point(new Position(-73.564453125, 42.114523952464246));
        return (args) -> userRepo
                .findAll()
                .forEach(System.out::println);
//        Point p = new Point(new Position(-73.564453125, 42.114523952464246));
//        return (args) -> userRepo
//                .findByResidenceNear(p, new Distance(10))
//                .forEach(System.out::println);
    }
}

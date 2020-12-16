package ch.bemyquarantine.bmqapi.user;

import ch.bemyquarantine.bmqapi.attitude.Answer;
import com.mongodb.client.model.geojson.Point;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Document
public class User {
    @Id
    private BigInteger id;
    private boolean active;
    private String username;
    private Gender gender;
    private Date dateOfBirth;
    private Set<Gender> gendersOfInterest;
    private RelationTyp relationTyp;

    @GeoSpatialIndexed(name = "Residence")
    private Point residence;

    @DBRef
    private Set<Answer> answer;

    public BigInteger getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public User setActive(boolean active) {
        this.active = active;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public User setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public User setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Point getResidence() {
        return residence;
    }

    public User setResidence(Point residence) {
        this.residence = residence;
        return this;
    }

    public Set<Gender> getGendersOfInterest() {
        return gendersOfInterest;
    }

    public User setGendersOfInterest(Set<Gender> gendersOfInterest) {
        this.gendersOfInterest = gendersOfInterest;
        return this;
    }

    public RelationTyp getRelationTyp() {
        return relationTyp;
    }

    public User setRelationTyp(RelationTyp relationTyp) {
        this.relationTyp = relationTyp;
        return this;
    }

    public User update(User user) {
        if (user.getRelationTyp() != null) this.setRelationTyp(user.getRelationTyp());
        if (user.getDateOfBirth() != null) this.setDateOfBirth(user.getDateOfBirth());
        if (user.getGendersOfInterest() != null) this.setGendersOfInterest(user.getGendersOfInterest());
        if (user.getGender() != null) this.setGender(user.getGender());
        if (user.getResidence() != null) this.setResidence(user.getResidence());
        if (user.getUsername() != null) this.setUsername(user.getUsername());

        this.setActive(user.isActive());

        return this;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", active=" + active +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", residence=" + residence +
                ", gendersOfInterest=" + gendersOfInterest +
                ", relationTyp=" + relationTyp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return active == that.active &&
                id.equals(that.id) &&
                username.equals(that.username) &&
                gender == that.gender &&
                dateOfBirth.equals(that.dateOfBirth) &&
                residence.equals(that.residence) &&
                gendersOfInterest.equals(that.gendersOfInterest) &&
                relationTyp == that.relationTyp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, active, username, gender, dateOfBirth, residence, gendersOfInterest, relationTyp);
    }
}

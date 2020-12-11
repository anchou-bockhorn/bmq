package ch.bemyquarantine.bmqapi.http;

import ch.bemyquarantine.bmqapi.persistance.UserRepo;
import ch.bemyquarantine.bmqapi.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
public class HttpUser {

    private final UserRepo userRepo;

    public HttpUser(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/user")
    public List<User> users() {
        return userRepo.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> user(@PathVariable String id) {
        return userRepo.findById(new BigInteger(id));
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userRepo.insert(user);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        if (user.getId().equals(new BigInteger(id))) {
            return userRepo.save(user);
        } else {
            return new User();
        }
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable String id) {
        userRepo.deleteById(new BigInteger(id));
    }
}

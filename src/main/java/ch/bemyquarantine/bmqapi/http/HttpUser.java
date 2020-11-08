package ch.bemyquarantine.bmqapi.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpUser {
    @GetMapping("/")
    String all() {
        return "bananas chiquita";
    }
}

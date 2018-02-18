package at.wizi.blog.controller;

import at.wizi.blog.controller.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/status", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StatusController {

    private final Environment environment;

    @Autowired
    public StatusController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/show")
    public Status showStatus() {
        return new Status(17, "all fine", getActiveSpringProfiles());
    }

    private String getActiveSpringProfiles() {
        return StringUtils.arrayToCommaDelimitedString(environment.getActiveProfiles());
    }
}

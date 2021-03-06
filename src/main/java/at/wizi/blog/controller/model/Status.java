package at.wizi.blog.controller.model;

import at.wizi.blog.config.ApplicationConfig;
import lombok.Data;

@Data
public class Status {
    private final int code;
    private final String message;
    private final String activeSpringProfiles;

    private final ApplicationConfig applicationConfig;
}

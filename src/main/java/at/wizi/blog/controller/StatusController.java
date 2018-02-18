package at.wizi.blog.controller;

import at.wizi.blog.config.ApplicationConfig;
import at.wizi.blog.controller.model.Status;
import org.springframework.beans.BeanUtils;
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
    private final ApplicationConfig applicationConfig;

    @Autowired
    public StatusController(Environment environment, ApplicationConfig applicationConfig) {
        this.environment = environment;
        this.applicationConfig = applicationConfig;
    }

    @GetMapping("/show")
    public Status showStatus() {
        return new Status(17, "all fine", getActiveSpringProfiles(), copyApplicationConfig());
    }

    private String getActiveSpringProfiles() {
        return StringUtils.arrayToCommaDelimitedString(environment.getActiveProfiles());
    }

    /**
     * copy the application config, otherwise we get the proxy class and can't serialize to json.
     * @return copy of ApplicationConfig
     */
    private ApplicationConfig copyApplicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        BeanUtils.copyProperties(this.applicationConfig, applicationConfig);
        return applicationConfig;
    }
}

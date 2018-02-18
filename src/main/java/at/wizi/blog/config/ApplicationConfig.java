package at.wizi.blog.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter // only used for BeanUtils.copyProperties in StatusController
@Configuration
public class ApplicationConfig {
    @Value("${app.size}")
    private int size;
    @Value("${app.environment-message}")
    private String environmentMessage;
}

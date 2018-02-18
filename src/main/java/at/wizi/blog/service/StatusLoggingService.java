package at.wizi.blog.service;

import at.wizi.blog.config.SchedulingConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Profile({"test", "prod"})
public class StatusLoggingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulingConfig.class);

    @Scheduled(fixedRate = 10000)
    public void logStatus() {
        LOGGER.info("all fine.");
    }
}

package com.ndhl.web.backend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@SpringBootApplication
@Slf4j
public class BackendLauncher {
    public static void main(String[] args) {
        log.warn("Application is running in Development mode which should be used by developers only!");
        SpringApplication.run(BackendConfig.class, args);
    }
}

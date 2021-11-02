package com.ndhl.web.backend;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackageClasses = BackendConfig.class)
@Slf4j
public class BackendConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}

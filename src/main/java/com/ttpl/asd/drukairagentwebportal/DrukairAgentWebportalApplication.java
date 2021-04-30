package com.ttpl.asd.drukairagentwebportal;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@EnableEncryptableProperties
@SpringBootApplication
public class DrukairAgentWebportalApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(DrukairAgentWebportalApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DrukairAgentWebportalApplication.class);
    }
}

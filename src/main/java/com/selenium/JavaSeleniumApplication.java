package com.selenium;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.ZoneId;

@SpringBootApplication
@EnableAsync
public class JavaSeleniumApplication {
    private static final Logger log = LoggerFactory.getLogger(JavaSeleniumApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        //SpringApplication.run(JavaSeleniumApplication.class, args);
        Environment env = new SpringApplication(JavaSeleniumApplication.class).run(args).getEnvironment();
        logEnv(env);

    }

    private static void logEnv(Environment env) throws UnknownHostException {
        log.info("********* " + LocalDateTime.now().toString());
        log.info("********* " + LocalDateTime.now(ZoneId.of("CET")).toString());

        log.info(
                "Access URLs:\n----------------------------------------------------------\n\t"
                        + "Develop: \thttp://127.0.0.1:{}\n\t"
                        + "Product: \thttp://{}:{}\n----------------------------------------------------------",
                env.getProperty("server.port"), InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }

}

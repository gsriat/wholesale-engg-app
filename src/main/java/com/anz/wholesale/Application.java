package com.anz.wholesale;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Main Application class
 */
@SpringBootApplication
@Slf4j
public class Application {

	public static void main(String[] args) throws UnknownHostException {

		ApplicationContext context = SpringApplication.run(Application.class, args);
        Environment env = context.getEnvironment();

        //Using Lombok to initialize logger so if not configured in
        //IDE, will complain for local variable log, but will
        //compile and run fine (mvn clean install).
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}\n\t" +
                        "External: \thttp://{}:{}" +
                        "\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
	}

}

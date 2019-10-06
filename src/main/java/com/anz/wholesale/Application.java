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

        // Please install Lombok plugin.
		// Open the Settings panel. Search for "Plugins", then search for "Lombok" in the plugins.
		// Find the plugin and install it. Finally, restart your IDEA. Then everything will be OK!
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

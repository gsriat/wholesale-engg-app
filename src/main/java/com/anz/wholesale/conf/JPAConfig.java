package com.anz.wholesale.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Configuration class for scanning JPA repositories
 */

@Configuration
@EnableJpaRepositories("com.anz.wholesale.repository")
public class JPAConfig {
}

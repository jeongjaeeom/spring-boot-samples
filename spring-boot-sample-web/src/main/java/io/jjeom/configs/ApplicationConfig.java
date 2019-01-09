package io.jjeom.configs;

import io.jjeom.accounts.Account;
import io.jjeom.accounts.AccountRepository;
import io.jjeom.accounts.AccountRole;
import io.jjeom.accounts.Role;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jeongjae Eom
 * @since 2018-12-21
 */
@Configuration
@Slf4j
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public ApplicationRunner applicationRunner(Environment environment, ApplicationInitializer applicationInitializer) {
        return new ApplicationRunner() {
            @Transactional
            @Override
            public void run(ApplicationArguments args) {
                for (final String profileName : environment.getActiveProfiles()) {
                    log.info("Currently active profile - {}", profileName);
                }
                applicationInitializer.setUp();
            }
        };
    }

    private interface ApplicationInitializer {
        void setUp();
    }

    @Component
    @Profile("!prod")
    private static class DevApplicationInitializer implements ApplicationInitializer {

        private AccountRepository accountRepository;
        private PasswordEncoder passwordEncoder;
        private AppProperties appProperties;

        private DevApplicationInitializer(AccountRepository accountRepository, PasswordEncoder passwordEncoder, AppProperties appProperties) {
            this.accountRepository = accountRepository;
            this.appProperties = appProperties;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        public void setUp() {
            log.info("appProperties.name: {}", appProperties.getName());
            log.info("Setting up for DEV environment.");
            Account adminAccount = Account.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("a123456A"))
                    .email("jeongjae.eom@gmail.com")
                    .build();
            adminAccount.addRole(AccountRole.builder().role(Role.ADMIN).build());
            // adminAccount.addRole(AccountRole.builder().role(Role.USER).build());
            accountRepository.save(adminAccount);
        }
    }

    @Component
    @Profile("prod")
    private static class ProdNotApplicationInitializer implements ApplicationInitializer {

        @Override
        public void setUp() {
            log.info("Setting up for PRODUCTION environment.");
        }
    }
}

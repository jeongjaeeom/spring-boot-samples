package io.jjeom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Component
    public class StartupApplicationListenerExample implements ApplicationListener<ContextRefreshedEvent> {

        @Autowired
        Environment environment;

        @Override
        public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
            for (final String profileName : environment.getActiveProfiles()) {
                System.out.println("Currently active profile - " + profileName);
            }
        }
    }

}

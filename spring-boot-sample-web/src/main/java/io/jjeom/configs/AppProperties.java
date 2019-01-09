package io.jjeom.configs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Jeongjae Eom
 * @since 2019-01-03
 */
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties("app")
public class AppProperties {
    private String name;
}
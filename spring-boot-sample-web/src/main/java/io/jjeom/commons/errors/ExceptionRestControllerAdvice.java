package io.jjeom.commons.errors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.Map;

/**
 * @author Jeongjae Eom
 * @since 2019-01-03
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestController
@ControllerAdvice(annotations = RestController.class)
@Slf4j
public class ExceptionRestControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Map<String, String> exception(Exception e) {
        log.error("Exception occurred", e);
        return Collections.singletonMap("response", "error");
    }
}

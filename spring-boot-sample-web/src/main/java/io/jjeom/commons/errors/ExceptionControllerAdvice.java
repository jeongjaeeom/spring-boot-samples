package io.jjeom.commons.errors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Jeongjae Eom
 * @since 2019-01-03
 */
@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public String exception(Exception e) {
        log.error("Exception occurred", e);
        return "/error2";
    }

}

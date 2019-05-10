package org.jjeom.restapi.commons;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author eomjeongjae
 * @since 2019-05-10
 */
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface TestDescription {

    String value();
}

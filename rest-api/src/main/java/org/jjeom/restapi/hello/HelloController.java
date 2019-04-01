package org.jjeom.restapi.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author eomjeongjae
 * @since 2019-03-04
 */
@Controller
public class HelloController {

    @GetMapping("/")
    @ResponseBody
    public String greeting() {
        return "Hello World";
    }
}

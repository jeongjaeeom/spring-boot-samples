package io.jjeom.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Jeongjae Eom
 * @since 2018-12-28
 */
@Controller
//@RequestMapping({"", "/"})
public class HomeController {

    @GetMapping
    public String home() {
        return "/home";
    }

}

package io.jjeom.home;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Jeongjae Eom
 * @since 2018-12-28
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return "/home";
    }

    @GetMapping("home")
    public String basicError() {
        throw new IllegalStateException("Basic Error");
    }

    @RequestMapping("/home2")
    public ResponseEntity<String> handle() throws URISyntaxException {
        URI location = new URI("/home");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<String>("Hello World!!!!!", responseHeaders, HttpStatus.CREATED);
    }

}

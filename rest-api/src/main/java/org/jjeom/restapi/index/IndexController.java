package org.jjeom.restapi.index;

import org.jjeom.restapi.events.EventController;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author eomjeongjae
 * @since 2019-05-10
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public ResourceSupport index() {
        ResourceSupport index = new ResourceSupport();
        index.add(linkTo(EventController.class).withRel("events"));
        return index;
    }
}

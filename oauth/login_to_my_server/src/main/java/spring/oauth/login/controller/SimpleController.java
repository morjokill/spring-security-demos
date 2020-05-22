package spring.oauth.login.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class SimpleController {
    @RequestMapping("/")
    String sayHello(Principal principal) {
        return "Wow oauth is so easy! (Hello! " + principal.getName() + ")";
    }
}

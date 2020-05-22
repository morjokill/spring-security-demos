package spring.oauth.login.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SimpleController {
    @RequestMapping("/")
    String sayHello() {
        return "Wow oauth is so easy! (Hello!)";
    }
}

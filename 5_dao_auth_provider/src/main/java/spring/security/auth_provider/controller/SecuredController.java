package spring.security.auth_provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured")
public class SecuredController {
    @RequestMapping("/hello")
    public String notSoBasicHello() {
        return "Hello there! Ahh shit...";
    }
}

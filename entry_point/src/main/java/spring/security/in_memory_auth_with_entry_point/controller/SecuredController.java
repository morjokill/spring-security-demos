package spring.security.in_memory_auth_with_entry_point.controller;

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

package spring.security.in_memory_auth_with_entry_point.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class SimpleController {
    @RequestMapping("/hello")
    public String basicHello() {
        return "Hello!";
    }
}

package spring.security.in_memory_auth_with_basic_login.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/hello")
    public String notSoBasicHello() {
        return "Sasuke! Come back to village...((";
    }
}

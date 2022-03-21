package spring.security.api.spring.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {
    @GetMapping("/v1")
    public  String Print(){
        return "Helloword";
    }
}

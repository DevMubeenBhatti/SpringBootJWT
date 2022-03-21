package spring.security.api.spring.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {
    @GetMapping("/v1")
    public  String Print(){
        return "Helloword";
    }
//    @GetMapping("/admin/hello")
//    public String  sayAdmin(String name){
//        return "Hello Admin" + name;
//    }
    @GetMapping("/admin/hello")
    public String sayAdminHello(String name) {
        return "Hello Admin "+name;
    }
}

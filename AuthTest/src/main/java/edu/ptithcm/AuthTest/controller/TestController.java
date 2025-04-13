package edu.ptithcm.AuthTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping("/admin")
    public String admin(){
        return "You login as admin";
    }

    @GetMapping("/tutor")
    public String tutor(){
        return "You login as tutor";
    }

    @GetMapping("/customer")
    public String customer(){
        return "You login as customer";
    }
}

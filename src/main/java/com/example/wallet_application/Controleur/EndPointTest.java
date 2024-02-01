package com.example.wallet_application.Controleur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndPointTest {
    @GetMapping("/ping")
    public String pingTest(){
        return "pong";
    }
}

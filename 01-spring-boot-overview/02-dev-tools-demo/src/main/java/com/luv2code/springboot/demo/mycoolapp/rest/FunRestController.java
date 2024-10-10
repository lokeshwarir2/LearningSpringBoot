package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String sayHello(){
        return "hello world";
    }
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "run fasst vicky";
    }
}

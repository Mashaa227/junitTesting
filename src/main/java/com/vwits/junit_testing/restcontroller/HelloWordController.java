package com.vwits.junit_testing.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    @SuppressWarnings("unused")
    @GetMapping("/hello")
    public String helloWord(){
        return "Hello I am Masha";
    }
}

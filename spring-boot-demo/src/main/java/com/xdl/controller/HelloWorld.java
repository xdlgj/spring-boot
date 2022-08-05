package com.xdl.controller;

import com.xdl.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@EnableAutoConfiguration
public class HelloWorld {
    @Autowired
    Car car;
    @RequestMapping("/car")
    Car car() {
        return car;
    }
    @RequestMapping("/")
    String home() {
        return "Hello world!";
    }
}

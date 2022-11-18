package com.springbootacademy.pointofsale.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

    public void getMyText(){
        String myText = "This is my springboot app";
        System.out.println(myText);
    }
}

package com.webApp.controller;

import com.webApp.clientsService.ClientsServiceImpl;
import com.webApp.clientsService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @RequestMapping("/api/login")
    public String welcome() {
        return "Welcome to javatechie !!";
    }
}

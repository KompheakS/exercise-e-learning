package com.kompheak.e.learning.controller;

import com.kompheak.e.learning.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @GetMapping("/string")
    public ResponseEntity<String> getStringFromServer(){
        return new ResponseEntity<>("hello from server side", HttpStatus.OK);
    }

}

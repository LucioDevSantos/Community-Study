package com.studyGuide.project.controllers;

import com.studyGuide.project.Utils.Utils;
import com.studyGuide.project.entitys.User;
import com.studyGuide.project.repositories.UserRepo;
import com.studyGuide.project.services.UserService;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    // Services
    @Autowired
    private UserService userService;
    @Autowired
    private Utils utils;

    // repositories
    @Autowired
    private UserRepo userRepo;


    @PostMapping("/register")
    public ResponseEntity<User> RegisterUser(@RequestBody User user){

            return ResponseEntity.status(HttpStatus.OK).body(userService.saveUser(user));

    }

    @PostMapping("/login")
    public ResponseEntity<User> LoginUser(@RequestParam String email, @RequestBody String password){

        return ResponseEntity.status(HttpStatus.OK).body(userService.loginUser(email, password));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody(required = false) String username, String nickname, @PathVariable Long id){

       return ResponseEntity.status(HttpStatus.OK).body(userService.Update(username, nickname, id));
    }

    @GetMapping("/{username}")
    public Optional<User> getUser(@PathVariable String username) {
        return userRepo.findByUsername(username);
    }

}

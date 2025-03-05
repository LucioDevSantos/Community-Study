package com.studyGuide.project.controllers;

import com.studyGuide.project.repositories.UserRepo;
import com.studyGuide.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @GetMapping("/request")
    public String resetRequest(@RequestParam String emailAddress) {
        if(userRepo.findByEmailAddress(emailAddress).isEmpty()) throw new RuntimeException("not found");

        return userService.sendCodeEmail(emailAddress);
    }

    @GetMapping("/verification")
    public boolean codeValidation(@RequestParam String email, @RequestBody String code) {
        return userService.codeValidation(email, code, false);
    }

    @PutMapping("/{code}/change-password")
    public String changePassword(@PathVariable String code, @RequestBody String new_password, String email) {
        if(!userService.codeValidation(email, code, true)) throw new RuntimeException("Invalid code");

        return userService.changePassword(email, new_password);
    }


}

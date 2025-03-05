package com.studyGuide.project.services;

import com.mongodb.lang.Nullable;
import com.studyGuide.project.entitys.SecurityToken;
import com.studyGuide.project.entitys.User;
import com.studyGuide.project.exceptions.InvalidPassword;
import com.studyGuide.project.repositories.TokenRepo;
import com.studyGuide.project.repositories.UserRepo;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TokenRepo tokenRepo;
    @Autowired
    private MailService mailService;
    @Autowired
    private EntityManager entityManager;




    public User saveUser(User user) {
        user.setUsername("@" + user.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepo.save(user);
    }

    public User loginUser(String email, String password) {
        User foundUser = userRepo.findByEmailAddress(email).orElseThrow(() -> new IllegalArgumentException("user not Found"));


        if (!new BCryptPasswordEncoder().matches(password, foundUser.getPassword()))
            throw new InvalidPassword("incorrect password");
        return foundUser;
    }

    public User Update(@Nullable String username, @Nullable String nickname, Long id) {
        User foundUser = userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("user not found"));
        if (nickname != null) foundUser.setNickname(nickname);
        if (username != null) foundUser.setUsername(username);

        return userRepo.save(foundUser);
    }

    public String sendCodeEmail(String email) {
        User user = userRepo.findByEmailAddress(email).orElseThrow(() -> new IllegalArgumentException("not found"));
        String code = new TokenService(tokenRepo).generateTokenEntity(email);
        return mailService.sendEmail(user.getEmailAddress(), "password change code verification", "verification code, if you aren't trying to change your password ignore this email! \n code: " + code);
    }

    public boolean codeValidation(String email, String code, boolean delete) {
        if(tokenRepo.findByEmailAddress(email).isEmpty()) throw new RuntimeException("Code not send");

        SecurityToken token = tokenRepo.findByEmailAddress(email).orElseThrow(() -> new IllegalArgumentException("not found"));

        if(new TokenService(tokenRepo).validateToken(token, code) && delete){
            tokenRepo.delete(token);
            return true;
        }

        return new TokenService(tokenRepo).validateToken(token, code);

    }

    public String changePassword(String email, String newPassword) {
        User user = userRepo.findByEmailAddress(email).orElseThrow(() -> new IllegalArgumentException("not found"));

        user.setPassword(new BCryptPasswordEncoder().encode(newPassword));

        return "Successful password reset!";
    }

}
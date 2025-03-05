package com.studyGuide.project.Utils;

import com.studyGuide.project.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class Utils {

    @Autowired
    private UserRepo userRepo;


    private static final SecureRandom random = new SecureRandom();


    public boolean VerifyEmail(String email) {
        return true;
    }

    public boolean existsEmail(String email) {
        return userRepo.findByEmailAddress(email).isPresent();
    }

    public int codeGenerator() {

        return random.nextInt(9000);
    }

    public String URLCodeGenerator(int size) {
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < size; i++) {
            int index = random.nextInt(CHARACTERS.length());
            code.append(CHARACTERS.charAt(index));
        }
        return code.toString();

    }

}

package com.studyGuide.project.services;

import com.studyGuide.project.Utils.Utils;
import com.studyGuide.project.entitys.SecurityToken;
import com.studyGuide.project.repositories.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TokenService {


    private final TokenRepo tokenRepo;

    @Autowired
    public TokenService(TokenRepo tokenRepo) {
        this.tokenRepo = tokenRepo;
    }


    public String generateTokenEntity(String emailAddress) {
        String generatedCode = String.valueOf(new Utils().codeGenerator());

        var tokenEntity = new SecurityToken();
        tokenEntity.setToken(generatedCode);
        tokenEntity.setEmailAddress(emailAddress);
        tokenEntity.setExpires(LocalDateTime.now().plusMinutes(5));
        tokenRepo.save(tokenEntity);

        return generatedCode;
    }

    public boolean validateToken(SecurityToken token, String code) {
        if(token.isExpired()) {
            tokenRepo.delete(token);
            return false;
        }
        return token.getToken().equals(code);
    }

}

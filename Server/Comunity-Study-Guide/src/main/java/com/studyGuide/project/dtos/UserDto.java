package com.studyGuide.project.dtos;

import com.studyGuide.project.entitys.Membership;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String username;
    private String nickname;
    private String email;
    private String password;
    private List<Membership> membership;



}

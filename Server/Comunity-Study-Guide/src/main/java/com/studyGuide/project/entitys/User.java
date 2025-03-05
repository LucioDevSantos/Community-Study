package com.studyGuide.project.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "email_address")
    @NotBlank(message = "email is fundamental")
    private String emailAddress;

    @Column(nullable = true, name = "nickname")
    private String nickname;

    @Column(nullable = false, name = "password")
    @Size(min = 5, message = "min 5 characters")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(unique = true, name = "username")
    private String username;

    @OneToMany(mappedBy = "user_id")
    private List<Membership> membership;


    public User(int id, String email, String nickname, String password) {
    }
}

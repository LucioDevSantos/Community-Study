package com.studyGuide.project.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tokens")
public class SecurityToken implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String token;

    @Column(unique = true, name = "email_address")
    private String emailAddress;

    @Column(nullable = false)
    private LocalDateTime expires;


    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expires);
    }

}

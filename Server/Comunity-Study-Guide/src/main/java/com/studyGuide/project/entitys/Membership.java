package com.studyGuide.project.entitys;


import com.studyGuide.project.dtos.Enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "membership")
public class Membership implements Serializable {

    @EmbeddedId
    private EnrollmentId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToOne
    @MapsId("communityId")
    @JoinColumn(name = "community_id")
    private Community community_id;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Roles role;

    @PrePersist
    public void prePersist() {
        if(role == null) {
            role = Roles.MEMBER;
        }
    }




}

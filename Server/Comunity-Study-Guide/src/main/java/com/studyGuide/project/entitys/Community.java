package com.studyGuide.project.entitys;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "communities")
public class Community implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    private int num_code;


    private Long admin_id;

    @OneToMany(mappedBy = "community_id")
    private List<Membership> members = new ArrayList<>();

    private int num_members;



}

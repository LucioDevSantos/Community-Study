package com.studyGuide.project.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Questions")
@Setter
@Getter
@NoArgsConstructor
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String topic;

    @Column(columnDefinition = "LONGTEXT")
    private String content;


    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Answers> answers = new ArrayList<>();



}
